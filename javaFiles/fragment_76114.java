JsonObject json = new JsonObject();
json.addProperty("foo", "bar");

Ion.with(context)
.load("http://example.com/post")
.setJsonObjectBody(json)
.asJsonObject()
.setCallback(new FutureCallback<JsonObject>() {
   @Override
    public void onCompleted(Exception e, JsonObject result) {
        // do stuff with the result or error
    }
});