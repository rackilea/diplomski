Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
dispatcher.getRegistry().addSingletonResource(new Service());

ResteasyProviderFactory
        .getContextDataMap()
        .put(HttpServletRequest.class, new MockHttpServletRequest());

MockHttpResponse response = new MockHttpResponse();

dispatcher.invoke(
    MockHttpRequest.get("/"),
    response
);