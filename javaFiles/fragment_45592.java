private void get(String key, Message<JsonObject> message) {
    webClient.get(webClientPort,
            webClientHost, "/document/" + key)
            .putHeader(HttpHeaders.CONTENT_TYPE.toString(), "application/json")
            .send(processResponse(message));
}

private void delete(String key, JsonObject body, Message<JsonObject> message) {
    webClient.delete(webClientPort,
            webClientHost, "/document/" + key)
            .putHeader(HttpHeaders.CONTENT_TYPE.toString(), "application/json")
            .send(processResponse(message));
}

private Handler<AsyncResult<HttpResponse<Buffer>>> processResponse( Message<JsonObject> message) {

    Handler<AsyncResult<HttpResponse<Buffer>>> handler = reply -> {
        if (reply.succeeded()) {
            message.reply(reply.result().bodyAsString());
        } else {
            message.fail(0, Json.encode(new JsonObject().put("error", reply.cause())));
        }
    };

    return handler;
}