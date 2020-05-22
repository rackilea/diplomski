@Override
public void onStartup(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(ApplicationConfig.class, WebConfig.class);

    servletContext.addListener(new ContextLoaderListener(rootContext));

    //Spring security
    servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null, false, "/*");

    //Enable multipart support
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(rootContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    dispatcher.setMultipartConfig(
            new MultipartConfigElement("/tmp", 25 * 1024 * 1024, 125 * 1024 * 1024, 1 * 1024 * 1024)
    );
}