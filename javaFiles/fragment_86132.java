Router router = Router.router(vertx);
// add a handler which sets the request body on the RoutingContext.
router.route().handler(BodyHandler.create());
// expose a POST method endpoint on the URI: /analyze
router.post("/analyze").handler(this::analyze);

// handle anything POSTed to /analyze
public void analyze(RoutingContext context) {
    // the POSTed content is available in context.getBodyAsJson()
    JsonObject body = context.getBodyAsJson();

    // a JsonObject wraps a map and it exposes type-aware getters
    String postedText = body.getString("text");

    context.response().end("You POSTed JSON which contains a text attribute with the value: " + postedText);
}