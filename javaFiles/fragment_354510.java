public class JerseyServletContainerInitializer implements ServletContainerInitializer {

  @Override
  public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {

    //Register spring configurations
    AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
    springContext.register(SpringConfig.class, JPAConfig.class);
    servletContext.addListener(new RequestContextListener());
    servletContext.addListener(new ContextLoaderListener(springContext));
    springContext.setServletContext(servletContext);

    //Register Jersey servlet
    ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("JerseyServlet", new ServletContainer());
    servletRegistration.addMapping("/api/*");
    servletRegistration.setLoadOnStartup(1);
    servletRegistration.setInitParameter("javax.ws.rs.Application", JerseyResourceConfig.class.getName());
  }
}