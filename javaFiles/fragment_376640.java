private Future<JsonArray> foo2(String uuid, Handler<AsyncResult<JsonObject>> aHandler) {
    JsonObject foo2 = new JsonObject();
    foo2.put("uuid", "foo2" + uuid);
    aHandler.handle(Future.succeededFuture(foo2));
    JsonArray arr = new JsonArray().add("123").add("456").add("789");
    return Future.succeededFuture(arr);
}