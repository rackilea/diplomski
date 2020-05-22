private void myMethod(RoutingContext routingContext, Handler<AsyncResult<AsyncReply>> handler) {
    //...
    if (condition) {
        // this does not work
        handler.handle(Future.succeededFuture(new AsyncReply(200, "")));
        return; // !!!!! 
    }

    // here I do an async call and use the handler appropriately
    HttpClientRequest productRequest = client.getAbs(url, h -> h.bodyHandler(bh -> {
           // works  
           handler.handle(Future.succeededFuture(new AsyncReply(200, "")));
    }

}