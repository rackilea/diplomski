List<RouteDefinition> routes = context.getRouteDefinitions();
    for (int i=0;  i<routes.size(); i++)    {
        context.getRouteDefinitions().get(i).adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                // mock all endpoints
                mockEndpoints("log*");
            }
        });
    }