public class FooInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        WebApplicationContext appContext = ...;

        ServletRegistration.Dynamic dispatcher =
           container.addServlet("dispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
 }