import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//@ComponentScan({"..."})
//@Import({})
public class Starter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter.class, args);
    }

    @Bean
    public ServletRegistrationBean apiV1() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
        applicationContext.setConfigLocation("classpath:/META-INF/spring/webmvc-context.xml");
        dispatcherServlet.setApplicationContext(applicationContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/api/1/*");
        servletRegistrationBean.setName("api-v1");

        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean apiV2() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ResourceConfig.class);
        dispatcherServlet.setApplicationContext(applicationContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/api/2/*");
        servletRegistrationBean.setName("api-v2");
        return servletRegistrationBean;
    }
}