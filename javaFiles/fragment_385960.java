public class MainVerticle extends AbstractVerticle {
    public static void log(String message) {
        System.out.printf("%s > %s\n", Instant.ofEpochMilli(System.currentTimeMillis()), message);
    }

    @Override
    public void start(Future<Void> fut) {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.route("/api/v1.0/log/write").handler(routingContext -> {
            log("Processing... ");
            JsonObject result = new JsonObject();
            result.put("status", "ok");
            routingContext.response().putHeader("content-type", "application/json").end(result.toString());
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(9231, result -> {
            if (result.succeeded()) {
                fut.complete();
            } else {
                fut.fail(result.cause());
            }
        });
    }
}