final ServletContextHandler servletContext
  = new ServletContextHandler(ServletContextHandler.SESSIONS);
servletContext.setContextPath("/");

servletContext.setAttribute("myAttr", new ArrayList<>());

servletContext.addServlet(ServerServlet.class, "/*");
servletContext.addServlet(DefaultServlet.class, "/");