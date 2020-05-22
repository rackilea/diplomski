class StringWrapperJsonDeserializer implements JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonArray()) {
            final JsonArray array = (JsonArray) json;
            final int size = array.size();
            if (size == 0) {
                return Collections.emptyList();
            }

            List<String> labels = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                JsonObject jsonElement = (JsonObject) array.get(i);
                Set<String> keys = jsonElement.keySet();
                for (String key : keys) {
                    labels.add(jsonElement.getAsJsonPrimitive(key).getAsString());
                }
            }

            return labels;
        }

        return Collections.emptyList();
    }
}