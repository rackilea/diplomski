public class ListOrStringDeserializer implements JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext context) 
            throws JsonParseException {

        List<String> items = Collections.emptyList();
        if (json.isJsonArray()) {
            items = context.deserialize(json, List.class);
        } else if (json.isJsonPrimitive()) {
            items = Collections.singletonList((String) context.deserialize(json, String.class));
        }
        return items;
    }
}