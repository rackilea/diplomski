import java.io.PrintStream;
import java.lang.reflect.Method;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import org.apache.axis.MessageContext;
import org.apache.axis.providers.java.RPCProvider;
import org.apache.axis.transport.http.HTTPConstants;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringProvider extends RPCProvider {

    private String springBeanId;

    public SpringProvider(String springBeanId) {
        this.springBeanId = springBeanId;
    }

    protected Object makeNewServiceObject(MessageContext msgContext, String clsName)
        throws Exception {
        Servlet servlet = (Servlet)msgContext.getProperty(HTTPConstants.MC_HTTP_SERVLET);
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletConfig().getServletContext());
        return wac.getBean(springBeanId);
    }

    protected Object invokeMethod(MessageContext msgContext, Method method, Object obj, Object argValues[])
        throws Exception {
        Method proxyMethod = obj.getClass().getMethod(method.getName(), method.getParameterTypes());
        return proxyMethod.invoke(obj, argValues);
    }

}