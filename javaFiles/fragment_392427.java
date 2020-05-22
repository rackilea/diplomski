public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebApplicationInitializer() {
    super(SecurityConfiguration.class);
    }

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
    final XmlWebApplicationContext appContext = new XmlWebApplicationContext();
    appContext.setConfigLocation("/WEB-INF/spring-web-servlet.xml");

    final ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",
        new DispatcherServlet(appContext));
    registration.setLoadOnStartup(1);
    registration.addMapping("/");
    registration.setMultipartConfig(new MultipartConfigElement("", 1000000, 1000000, 100000));
    }
}