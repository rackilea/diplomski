public class GetItemsService {
    public void retrieveItems(Vertx vertx, RoutingContext routingContext) {
        new GetLocationsManager().getItems(vertx, routingContext) // returns Future<JsonObject>
            .setHandler(handler -> {
                //Note2: this codeblock is executed when your future is completed (or failed)
                if(handler.succeeded()){
                    //Note3: handler.result() contains the result from the getItems call (future.complete(data))
                    JsonObject items = handler.result();
                    doSomethingWithTheItems(items);
                    String itemsEncodedToString = items.encode();
                    // serve the response
                    routingContext.response().end(itemsEncodedToString);
                }else{
                    // serve error response
                    routingContext.response().end("something terrible happened" + handler.cause());
                }
        });
    }

    public void doSomethingWithTheItems(JsonObject items){
        // do something here with your items
    }
}