context = new ServletContextHandler(ServletContextHandler.SESSIONS);
// ... more server creation

ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);

wscontainer.addEndpoint(ServerEndpointConfig.Builder.create(MyEndpoint.class, "/path/")
    .configurator(new MyConfigurator(aSocketManagerObject))
    .build());