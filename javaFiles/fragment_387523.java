static JsonArray bruteForceJsonArray(JsonObject object, String key) {
    if (object.get(key).isJsonArray()) {
        return object.get(key).getAsJsonArray();
    } else {
        JsonArray oneElementArray = new JsonArray();
        oneElementArray.add(new JsonObject());
        return oneElementArray;
    }
}