ServletRegistration.Dynamic dispatcher = 
            container.addServlet("dispatcher", dispatcherServlet);
dispatcher.setLoadOnStartup(1);
dispatcher.addMapping("/*");

dispatcher.setMultipartConfig(new MultipartConfigElement("/tmp", 1024*1024*5, 1024*1024*5*5, 1024*1024));