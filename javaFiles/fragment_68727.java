// You forgot about this!
servletContextHandler.addEventListener(new ContextLoaderListener());
servletContextHandler.setInitParameter("contextConfigLocation", "classpath*:**/hateos-spring-text.xml");

// You basically already have this part. Added for clarity
final ServletHolder jerseyServlet = new ServletHolder(SpringServlet.class);
jerseyServlet.setInitOrder(0);
jerseyServlet.setInitParameter(
     "com.sun.jersey.config.property.packages",
     "com.hateos.spring.test01"
);

servletContextHandler.addServlet(jerseyServlet, "/*");