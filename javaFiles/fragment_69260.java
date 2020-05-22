context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
   @Override
    public void configure() throws Exception {
       replaceFromWith("direct:triggerFoo");
       //...
    }
});