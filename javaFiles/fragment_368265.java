ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/server");
ServletHolder jerseyServletHolder = new ServletHolder(ServletContainer.class);
jerseyServletHolder.setInitParameter("com.sun.jersey.config.property.packages", "my.package.to.scan");
servletContextHandler.addServlet(jerseyServletHolder, "/*");
MyRestResource resource = new MyRestResource(param1, param2);
// Set resource as a context attribute
servletContextHandler.setAttribute("rest-1", resource);