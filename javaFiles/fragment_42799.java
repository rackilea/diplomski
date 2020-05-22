import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import javax.jws.WebMethod;
import javax.servlet.ServletConfig;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.service.factory.ReflectionServiceFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

public class MyCXFServlet extends CXFNonSpringServlet
{
    @Override
    protected void loadBus(ServletConfig sc) 
    {
        super.loadBus(sc);
        publishServices();
    }

    private void publishServices()
    {
        Set<Class> serviceInterfaces = new HashSet<>();
        serviceInterfaces.add(de.test.IUserService.class);
        serviceInterfaces.add(de.test.ILoginService.class);

        for (Class aSVCInterface : serviceInterfaces)
        {
            final String serviceName = aSVCInterface.getSimpleName();

            try
            {
                ReflectionServiceFactoryBean reflectionFactory = new ReflectionServiceFactoryBean(){
                    @Override
                    protected boolean isValidMethod(Method method)
                    {
                        boolean ret = super.isValidMethod(method);
                        WebMethod wm = method.getAnnotation(WebMethod.class);
                        if (wm != null && wm.exclude())
                            ret = false;
                        return ret;
                    }

                    @Override
                    protected String getServiceName() //Override for custom service name
                    {
                        return serviceName;
                    }

                };
                reflectionFactory.setServiceClass(aSVCInterface);

                Object proxiedServiceObject = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{aSVCInterface}, new de.test.MyWebServiceInvocationHandler(aSVCInterface));

                ServerFactoryBean factory = new ServerFactoryBean(reflectionFactory);
                factory.setBus(getBus());
                factory.setServiceClass(aSVCInterface);
                factory.setServiceBean(proxiedServiceObject);
                factory.setAddress("/" + serviceName);
                Server svr = factory.create();    
                svr.getEndpoint().getInInterceptors().add(new de.test.MyServiceInterceptor());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
}