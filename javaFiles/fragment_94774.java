// You named it WebConfig
public class WebAppInitializer implements WebApplicationInitializer { // web.xml replacement
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

    // Here you need to change "io.shido.config" to your config location
    applicationContext.setConfigLocation("io.shido.config");

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
        new DispatcherServlet(applicationContext)); // Register and map the dispatcher servlet

    //servletContext.setInitParameter("spring.profiles.default", "development");
    servletContext.addListener(new ContextLoaderListener(applicationContext));
    //applicationContext.register(AppConfig.class); // Manage the lifecycle of the root application context
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/web/*"); // ...and here also change the context
  }
}