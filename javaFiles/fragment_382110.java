class TypeAwareListJsonSeserializer implements JsonSerializer<List<?>> {
    @Override
    public JsonElement serialize(List<?> src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return JsonNull.INSTANCE;
        }
        JsonArray array = new JsonArray();
        for (Object item : src) {
            JsonElement jsonElement = context.serialize(item, item.getClass());
            array.add(jsonElement);
        }
        return array;
    }
}