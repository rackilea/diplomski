class Custom implements JsonDeserializer<NestedPojo> {
    @Override
    public NestedPojo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        NestedPojo nestedPojo = new NestedPojo();
        JsonArray jsonArray = json.getAsJsonArray();
        if (jsonArray.size() != 1) {
            throw new IllegalStateException("unexpected json");
        }
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject(); // get only element
        JsonElement jsonElement = jsonObject.get("name");
        if (!jsonElement.isJsonNull()) {
            nestedPojo.name = jsonElement.getAsString();
        }
        nestedPojo.value = jsonObject.get("value").getAsInt();
        return nestedPojo;
    }
}

Gson gson = new GsonBuilder().registerTypeAdapter(NestedPojo.class, new Custom()).create();