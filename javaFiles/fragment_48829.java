public class GetItemsService {
    public void retrieveItems(Vertx vertx, RoutingContext routingContext) {
        new GetLocationsManager().getItems(vertx, routingContext);
            .compose(this::doSomethingAsyncWithTheItems)
            .setHandler(handler -> {
                if(handler.succeeded()){
                    //Note4: handler.result() contains the result from the doSomethingAsyncWithTheItems call (future.complete(...))
                    JsonObject didSomethingWithTheItems = handler.result();
                    routingContext.response().end(didSomethingWithTheItems.encode());
                }else{
                    // serve error response
                    routingContext.response().end("something terrible happened");
                }
        });
    }

    public Future<JsonObject> doSomethingAsyncWithTheItems(JsonObject items){
        Future<JsonObject> future = Future.future(); 
        otherAsyncCallThatReturnsAFuture.setHandler(handler -> {
            if(handler.succeeded()){
                future.complete(...)
            }else{
                future.fail(...)
            }
        })
        return future;
    }
}