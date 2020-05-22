package util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanServer;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.StandardMBean;

import org.apache.log4j.Logger;

import sun.management.Agent;

public class JmxUtils {
    private static Logger log = Logger.getLogger(JmxUtils.class);
    private static Map<Object, String> weakMBeans = new ConcurrentHashMap<Object, String>();
    static {
        verifyJmxAgentStarted();
    }

    private static final int getAvailablePort() throws IOException {
        ServerSocket s = new ServerSocket(0);
        int result = s.getLocalPort();
        s.close();
        return result;
    }

    /**
     * @param objName
     *            domain:type=value[,name=value]
     * @param implementation
     * @param mbeanInterface
     * @see ObjectName
     * @see StandardMBean
     */
    public static final <I> ObjectInstance registerMBean(String objName, I implementation, Class<I> mbeanInterface) {
        int counter = 0;
        String uniqueSuffix = "";
        final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        while (true) {
            try {
                final ObjectName name = new ObjectName(objName + uniqueSuffix);
                final StandardMBean mbean = new StandardMBean(implementation, mbeanInterface);
                return mbs.registerMBean(mbean, name);
            } catch (final InstanceAlreadyExistsException e) {
                uniqueSuffix = "" + ++counter;
            } catch (final Exception e) {
                throw new Error(e);
            }
        }
    }

    /**
     * Weak MBean will not prevent resource it is monitoring from been garbage collected. MBean will be automatically unregistered.
     * 
     * @param objName
     *            domain:type=value[,name=value]
     * @param implementation
     * @param mbeanInterface
     * @see ObjectName
     * @see StandardMBean
     * @see WeakReference
     */
    public static final <I> ObjectInstance registerWeakMBean(String objName, I implementation, Class<I> mbeanInterface) {
        I proxy = DisposableWeakReference.newWeakReferenceProxy(new DisposableWeakReference<I>(implementation) {
            @Override
            public void dispose(Object disposable) {
                unregisterMBean(weakMBeans.remove(disposable));
            }
        }, mbeanInterface);
        ObjectInstance instance = registerMBean(objName, proxy, mbeanInterface);
        weakMBeans.put(proxy, instance.getObjectName().getCanonicalName());
        return instance;
    }

    public static <T> T newJmxClient(Class<T> clazz, String objectName, String serviceUrl) {
        return createJmxClient(clazz, objectName, serviceUrl, null, null);
    }

    public static <T> T newJmxClient(Class<T> clazz, String objectName, String serviceUrl, final String user, final String pass) {
        try {
            JMXServiceURL jmxServiceUrl = new JMXServiceURL(serviceUrl);
            Map<String, ?> env = user == null ? null : new HashMap<String, Object>() {{
                put(JMXConnector.CREDENTIALS, new String[] {user, pass});
            }};
            JMXConnector jmxc = JMXConnectorFactory.connect(jmxServiceUrl, env);
            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
            ObjectName mbeanName = new ObjectName(objectName);
            return JMX.newMBeanProxy(mbsc, mbeanName, clazz, true);
        } catch (IOException | MalformedObjectNameException e) {
            throw new RuntimeException("Can not create client for remote JMX " + serviceUrl, e);
        }
    }

    /**
     * @param objName
     * @see ObjectName
     */
    public static final void unregisterMBean(String objName) {
        try {
            final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            final ObjectName name = new ObjectName(objName);
            mbs.unregisterMBean(name);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final void verifyJmxAgentStarted() {
        try {
            String port = System.getProperty("com.sun.management.jmxremote.port");
            if (port == null) {
                port = String.valueOf(getAvailablePort());
                System.setProperty("com.sun.management.jmxremote.port", port);
                System.setProperty("com.sun.management.jmxremote.ssl", "false");
                System.setProperty("com.sun.management.jmxremote.authenticate", "false");

                Agent.startAgent();
            }
            log.info(InetAddress.getLocalHost().getCanonicalHostName() + ":" + port);
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}