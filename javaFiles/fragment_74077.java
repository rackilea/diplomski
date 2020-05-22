JsonParser parser = new JsonParser();
JsonObject object = (JsonObject)parser.parse(yourString);

for (Map.Entry<String,JsonElement> entry : object.entrySet()) {
    JsonArray array = entry.getValue().getAsJsonArray();
    for (JsonElement elementJSON : array) {
        [...]
    }
}