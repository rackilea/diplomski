AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
    webContext.register(MvcConfig.class);

    ContextLoaderListener contextLoaderListener = new ContextLoaderListener(webContext);
    servletContext.addListener(contextLoaderListener);

    DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");