(function () {
  var context;
  with(new JavaImporter(
    org.eclipse.jetty.server.handler
  , org.eclipse.jetty.util.resource
  )) {
    context = new ContextHandler();
    context.setContextPath("/");
    var handler = new (Java.extend(ResourceHandler, {
      getResource: function(req) {
        var path = req.getUri();
        var resource = Resource.newClassPathResource(path);
        if (resource == null || !resource.exists()) {
          resource = Resource.newClassPathResource("META-INF/resources/webjars" + path);
        }
        return resource;
      }
    }))();
    handler.setDirectoriesListed(true); // true when debugging, false in production
    context.setHandler(handler);
  }
  return context;
})();