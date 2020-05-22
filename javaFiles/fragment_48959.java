(function () {
  var context;
  with(new JavaImporter(
    org.eclipse.jetty.server.handler
  , org.eclipse.jetty.util.resource
  )) {
    context = new ContextHandler();
    context.setContextPath("/");
    var handler = new ResourceHandler();
    handler.setBaseResource(Resource.newResource("public"));
    context.setHandler(handler);
  }
  return context;
})();