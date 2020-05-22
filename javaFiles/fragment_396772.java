Path webRootPath = new File(www).toPath().toRealPath();

ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
context.setContextPath("/");
context.setBaseResource(new PathResource(webRootPath));
context.setWelcomeFiles(new String[] { "index.html" });
server.setHandler(context);

// Add the websocket filter
WebSocketUpgradeFilter wsfilter = WebSocketUpgradeFilter.configureContext(context);
wsfilter.getFactory().getPolicy().setIdleTimeout(5000);
wsfilter.addMapping(new ServletPathSpec("/stream"), new StreamingSocketCreator());

// Add the /test servlet mapping
ServletHolder holderTest = new ServletHolder("test", TestServlet.class);
holderTest.setInitParameter("dirAllowed","true");
context.addServlet(holderTest,"/test/*");

// NOTE! If you don't add the DefaultServlet, your 
// resources won't get served!
ServletHolder holderDefault = new ServletHolder("default", DefaultServlet.class);
holderDefault.setInitParameter("dirAllowed", "true");
context.addServlet(holderDefault, "/");

server.start();
server.join();