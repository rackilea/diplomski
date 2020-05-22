with(new JavaImporter(
  org.eclipse.jetty.server
, org.eclipse.jetty.server.handler
)) {

  var server = new Server(4567);

  var ctxs = new ContextHandlerCollection();
  ctxs.setHandlers(Java.to([
    load('src/static.js')
  , load('src/webjars.js')
  ], Handler.class.getName().concat('[]')));
  server.setHandler(ctxs);

  server.start();
  server.join();

}