context.getRouteDefinition("start").adviceWith(context, new AdviceWithRouteBuilder() {
        @Override
        public void configure() throws Exception {
            // mock log endpoints
            mockEndpoints("log*");
        }
    });