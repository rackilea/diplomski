Server server = new Server(8080);

    // Configure SOAP servlet
    SOAPServlet servlet = new SOAPServlet();
    ServletHolder SOAPServletHolder = new ServletHolder(servlet);

    ServletContextHandler SOAPContext = new ServletContextHandler(server,"/",ServletContextHandler.SESSIONS);
    SOAPContext.addServlet(SOAPServletHolder, "/*");

    // Set server context handlers
    ContextHandlerCollection contexts = new ContextHandlerCollection();
    contexts.setHandlers(new Handler []{SOAPContext});
    server.setHandler(contexts);

    // Publish SOAP Web service endpoints
    servlet.publish("/MyWebServiceRelativeURL", new MyWebServiceImpl());

    server.start();
    server.join();