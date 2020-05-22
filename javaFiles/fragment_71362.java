class RepliesJsonDeserializer implements JsonDeserializer<List<Reply>> {

    @Override
    public List<Reply> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonArray()) {
            JsonArray array = json.getAsJsonArray();
            List<Reply> replies = new ArrayList<>(array.size());
            array.forEach(item -> replies.add(context.deserialize(item, Reply.class)));

            return replies;
        }

        // in all other case empty list or null
        return Collections.emptyList();
    }
}