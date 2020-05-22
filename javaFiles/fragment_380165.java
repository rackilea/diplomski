public void testAdvised() throws Exception {
    // advice the first route using the inlined route builder
    context.getRouteDefinition("Actions").adviceWith(context, new RouteBuilder() {
        @Override
        public void configure() throws Exception {
            replaceFromWith("direct:start");
            weaveByToString(".*method1.*").after().to("mock:choice1");
            weaveByToString(".*method2.*").after().to("mock:choice2");
        }
    });

    getMockEndpoint("mock:choice1").expectedMessageCount(1);
    getMockEndpoint("mock:choice2").expectedMessageCount(0);

    template.sendBody("direct:start", "Hello World");

    assertMockEndpointsSatisfied();
}