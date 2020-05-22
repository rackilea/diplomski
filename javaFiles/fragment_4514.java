public class HttpsServerVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    // Setup the HTTPS
    var httpOptions = new HttpServerOptions()
      .setCompressionSupported(true)
      .setPort(443)
      .setSsl(true)
      .setPemTrustOptions(...)
      .setPemKeyCertOptions(...);

    // Start the server and the routes
    var server = vertx.createHttpServer(httpOptions);
    var router = Router.router(vertx);

    //Start
    server
      .requestHandler(router)
      .listen(ar -> {
        if (ar.succeeded()) {
          startPromise.complete();
        } else {
          startPromise.fail(ar.cause());
        }
      });
  }

}