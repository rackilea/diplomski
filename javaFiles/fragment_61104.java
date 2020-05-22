class CustomDeserializer implements JsonDeserializer<Word> {
    @Override
    public Word deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException {
        JsonElement content = je.getAsJsonObject().get("Word");
        return new Gson().fromJson(content, type);
    }
}