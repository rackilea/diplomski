public class HttpsServerVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    var server = vertx.createHttpServer(httpOptions);
    var router = Router.router(vertx);

    //Start
    server
      .requestHandler(r -> {
          r.response()
           .setStatusCode(301)
           .putHeader("Location", r.absoluteURI().replace("http", "https"))
           .end();
      });
  }

}