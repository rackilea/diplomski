public class GetItemsManager {
public Future<JsonObject> getItems(Vertx vertx, RoutingContext routingContext) {
    //Note1: you can create the future here, no need to pass as a parameter
    Future<JsonObject> future = Future.future(); 
    ...
    webClient.post(80, Constants.API_URL, "/items")
        ...
        .sendJsonObject(new JsonObject().put("mutator", "*"), ar -> {
            if (ar.succeeded()) {
                ...
                future.complete(data);
            } else {
                future.fail(new JsonObject().put("error", ar.cause().getMessage()).encode());
            }
        });
        return future;
}
}