if (ar.succeeded()) {
routingContext.response().setStatusCode(200).setStatusMessage("OK")
.putHeader("content-type", "application/json")
.putHeader("Access-Control-Allow-Origin", "https://login.com")
.putHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS")
.putHeader("Access-Control-Allow-Credentials", "true")
.end(
Json.encodePrettily(ar.result().body())
//(String) ar.result().body()
);
routingContext.response().close();