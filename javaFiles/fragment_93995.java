Router router = Router.router(vertx);
    router.route("/api/*").handler(event -> {
        if(event.request().getHeader("X-Requested-With") == null){
            event.response().setStatusCode(403).putHeader("content-type", "application/json; charset=utf-8").end("{\"message\":\"Not authorized\"}");
        }else{
            event.next();
        }
    });