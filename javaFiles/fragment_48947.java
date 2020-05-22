package org.apache.catalina.ha.tcp;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.ha.CatalinaCluster;
import org.apache.catalina.ha.ClusterValve;
import org.apache.catalina.ha.session.ReplicatedSession;
import org.apache.catalina.ha.session.SimpleTcpReplicationManager;
import org.apache.catalina.util.LifecycleSupport;
//import org.apache.catalina.util.StringManager;
import org.apache.catalina.valves.ValveBase;

/**
 * <p>With the {@link SimpleTcpReplicationManager} effectively deprecated, this allows
 * mutable objects to be replicated in the cluster by forcing the "dirty" status on 
 * every request.</p> 
 * 
 * @author Jon Brisbin (via post on tomcat-users http://markmail.org/thread/rdo3drcir75dzzrq)
 * @author Kevin Jansz
 */
public class ForceReplicationValve extends ValveBase implements Lifecycle, ClusterValve {
    private static org.apache.juli.logging.Log log =
        org.apache.juli.logging.LogFactory.getLog( ForceReplicationValve.class );

    @SuppressWarnings("hiding")
    protected static final String info = "org.apache.catalina.ha.tcp.ForceReplicationValve/1.0";

// this could be used if ForceReplicationValve messages were setup 
// in org/apache/catalina/ha/tcp/LocalStrings.properties
//    
//    /**
//     * The StringManager for this package.
//     */
//    @SuppressWarnings("hiding")
//    protected static StringManager sm =
//        StringManager.getManager(Constants.Package);

    /** 
     * Not actually required but this must implement {@link ClusterValve} to 
     * be allowed to be added to the Cluster.
     */
    private CatalinaCluster cluster = null ;

    /**
     * Also not really required, implementing {@link Lifecycle} to allow 
     * initialisation and shutdown to be logged. 
     */
    protected LifecycleSupport lifecycle = new LifecycleSupport(this);    


    /**
     * Default constructor
     */
    public ForceReplicationValve() {
        super();
        if (log.isInfoEnabled()) {
            log.info(getInfo() + ": created");
        }
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void invoke(Request request, Response response) throws IOException,
            ServletException {

        getNext().invoke(request, response);

        Session session = null;
        try {
            session = request.getSessionInternal();
        } catch (Throwable e) {
            log.error(getInfo() + ": Unable to perform replication request.", e);
        }

        String context = request.getContext().getName();
        String task = request.getPathInfo();
        if(task == null) {
            task = request.getRequestURI();
        }
        if (session != null) {
            if (log.isDebugEnabled()) {
                log.debug(getInfo() + ": [session=" + session.getId() + ", instanceof=" + session.getClass().getName() + ", context=" + context + ", request=" + task + "]");
            }
            if (session instanceof ReplicatedSession) {
                // it's a SimpleTcpReplicationManager - can just set to dirty
                ((ReplicatedSession) session).setIsDirty(true);
                if (log.isDebugEnabled()) {
                    log.debug(getInfo() + ": [session=" + session.getId() + ", context=" + context + ", request=" + task + "] maked DIRTY");
                }
            } else {
                // for everything else - cycle all attributes
                List cycledNames = new LinkedList();

                // in a cluster where the app is <distributable/> this should be
                // org.apache.catalina.ha.session.DeltaSession - implements HttpSession
                HttpSession deltaSession = (HttpSession) session;
                for (Enumeration<String> names = deltaSession.getAttributeNames(); names.hasMoreElements(); ) {
                    String name = names.nextElement();
                    deltaSession.setAttribute(name, deltaSession.getAttribute(name));

                    cycledNames.add(name);                    
                }

                if (log.isDebugEnabled()) {
                    log.debug(getInfo() + ": [session=" + session.getId() + ", context=" + context + ", request=" + task + "] cycled atrributes=" + cycledNames + "");
                }
            }
        } else {
            String id = request.getRequestedSessionId();
            log.warn(getInfo()  + ": [session=" + id + ", context=" + context + ", request=" + task + "] Session not available, unable to send session over cluster.");
        }
    }


    /* 
     * ClusterValve methods - implemented to ensure this valve is not ignored by Cluster  
     */

    public CatalinaCluster getCluster() {
        return cluster;
    }

    public void setCluster(CatalinaCluster cluster) {
        this.cluster = cluster;
    }


    /* 
     * Lifecycle methods - currently implemented just for logging startup 
     */

    /**
     * Add a lifecycle event listener to this component.
     *
     * @param listener The listener to add
     */
    public void addLifecycleListener(LifecycleListener listener) {
        lifecycle.addLifecycleListener(listener);
    }

    /**
     * Get the lifecycle listeners associated with this lifecycle. If this 
     * Lifecycle has no listeners registered, a zero-length array is returned.
     */
    public LifecycleListener[] findLifecycleListeners() {
        return lifecycle.findLifecycleListeners();
    }

    /**
     * Remove a lifecycle event listener from this component.
     *
     * @param listener The listener to remove
     */
    public void removeLifecycleListener(LifecycleListener listener) {
        lifecycle.removeLifecycleListener(listener);
    }

    public void start() throws LifecycleException {
        lifecycle.fireLifecycleEvent(START_EVENT, null);
        if (log.isInfoEnabled()) {
            log.info(getInfo() + ": started");
        }
    }

    public void stop() throws LifecycleException {
        lifecycle.fireLifecycleEvent(STOP_EVENT, null);
        if (log.isInfoEnabled()) {
            log.info(getInfo() + ": stopped");
        }
    }

}