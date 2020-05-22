@SpringBootApplication
@ComponentScan(basePackages = { "routes", "service" },
    excludeFilters = {@ComponentScan.Filter(value = Controller.class,     
    type = FilterType.ANNOTATION)})

public class Application  {

    public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/service/*");
        registration.setName("CamelServlet");
        return registration;
    }
}