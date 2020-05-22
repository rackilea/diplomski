final WebAppContext context = new WebAppContext();
context.setServer(httpServer);
context.setContextPath("/");
context.addServlet(new ServletHolder(new TestServlet()), "/*");
context.setWar(warFile.getAbsolutePath());
context.setExtractWAR(true);
context.setClassLoader(Thread.currentThread().getContextClassLoader());
context.setInitParameter("ui", MainUI.class.getCanonicalName());
httpServer.setHandler(context);