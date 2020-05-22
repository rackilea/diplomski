ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/server");
ServletHolder jerseyServletHolder = new ServletHolder(ServletContainer.class);
jerseyServletHolder.setInitParameter("com.sun.jersey.config.property.packages", "my.package.to.scan");
servletContextHandler.addServlet(jerseyServletHolder, "/*");
MyRestResource resource = new MyRestResource(param1, param2);
// wrap resource in a ServletHolder
ServletHolder resourceHolder = new ServletHolder(resource);
// assign resource to a Servlet pathSpec
servletContextHandler.addServlet(resourceHolder, "/rest");