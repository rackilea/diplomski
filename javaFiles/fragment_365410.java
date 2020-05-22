class TranslationDeserializer implements JsonDeserializer<List<Translation>> {
    @Override
    public List<Translation> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Translation> list = new ArrayList<>();
        for(Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
            list.add(new Translation(entry.getKey(), entry.getValue().getAsString()));
        }
        return list;
    }
}