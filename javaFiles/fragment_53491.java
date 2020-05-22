JsonObject object;
ArrayList<Integer> codes = new ArrayList<Integer>();
for (Map.Entry<String,JsonElement> entry : object.entrySet()) {
    JsonArray array = entry.getValue().getAsJsonObject().getAsJsonArray("unterfeld");
    for (JsonElement codeHolder : array) {
        codes.add(codeHolder.getAsJsonObject().getAsJsonPrimitive("code").getAsInt());
    }
}