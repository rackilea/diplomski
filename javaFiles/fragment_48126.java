final ServletContextHandler servletContext
   = new ServletContextHandler(ServletContextHandler.SESSIONS);
servletContext.setContextPath("/");

servletContext.setInitParameter(
  "org.restlet.application", MyApplication.class.getName());
servletContext.setInitParameter("test", "my param"); <-----------

servletContext.addServlet(ServerServlet.class, "/*");
servletContext.addServlet(DefaultServlet.class, "/");