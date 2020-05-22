class ArrayDeserializer implements JsonDeserializer<int[]> {
    @Override
    public int[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray("test");
        return context.deserialize(jsonArray, int[].class);
    }
}