import org.jboss.system.ServiceControllerMBean;
import org.jboss.system.ServiceMBeanSupport;

public class MyService extends ServiceMBeanSupport {

    public void workWithEar() 
    {
        ServiceControllerMBean serviceController = (ServiceControllerMBean) MBeanProxy.get(
                    ServiceControllerMBean.class,
                    ServiceControllerMBean.OBJECT_NAME, server);
        // server is ServiceMBeanSupport member

        ClassLoader cl = serviceController.getClass().getClassLoader();

        String path = cl.getResource("META-INF/jboss-service.xml").getPath()
        InputStream file = cl.getResourceAsStream("META-INF/jboss-service.xml");
    }
}