import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.unbound.Unbound;

@Interceptor
@RequestContextOperation
public class RequestContextInterceptor {

    /** The RequestContext */
    @Inject
    @Unbound
    private RequestContext m_requestContext;

    /**
     * 
     * @param p_invocationContext
     * @return
     * @throws Exception
     */
    @AroundInvoke
    public Object activateRequestContext(final InvocationContext p_invocationContext) throws Exception {
        try {
            m_requestContext.activate();
            return p_invocationContext.proceed();
        } finally {
            m_requestContext.invalidate();
            m_requestContext.deactivate();
        }
    }
}