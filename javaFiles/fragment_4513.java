public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {

    //Deploy the HTTPS server
    vertx.deployVerticle(
      "com.albertomiola.equations.http.HttpsServerVerticle",
      new DeploymentOptions().setInstances(n)
    );

    //Deploy the HTTP server
    vertx.deployVerticle(
      "com.albertomiola.equations.http.HttpServerVerticle",
      new DeploymentOptions().setInstances(1)
    );
  }

}