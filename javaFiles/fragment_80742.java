Server server = new Server();
HandlerList handlers = new HandlerList();
server.setHandler(handlers);

ServletContextHandler context = getAspireWebAppContext();
handlers.addHandler(context);

ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext( context );
wscontainer.addEndpoint(EngineSocket.class);
wscontainer.addEndpoint(WorkbenchSocket.class);

// RewriteHandler stuff
handlers.addHandler(rewrite);

server.start();