final JsonArray datasets = new JsonArray();
for (String key: dbObject.keySet()) {
    JsonObject dataset = new JsonObject();
    dataset.addProperty("title", key);
    datasets.add(dataset);
}