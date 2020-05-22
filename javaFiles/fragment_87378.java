public SNAPSHOTApp(int port) throws Exception {
    resource = new TheResource();
    Set<Object> resourceSingletons = new HashSet<>();
    resourceSingletons.add(resource);

    CXFNonSpringJaxrsServlet context = new CXFNonSpringJaxrsServlet(resourceSingletons);

    ServletHolder servlet = new ServletHolder(context);
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(servlet, "/*");
    handler.setContextPath("/snapshot");

    Server server = new Server(port);
    server.setHandler(handler);
    server.start();
    server.join();
}