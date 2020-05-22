final class JSONObjectJsonDeserializer
        implements JsonDeserializer<JSONObject> {

    // The implementation is fully thread-safe and can be instantiated once
    private static final JsonDeserializer<JSONObject> jsonObjectJsonDeserializer = new JSONObjectJsonDeserializer();

    // Type tokens are immutable values and therefore can be considered constants (and final) and thread-safe as well
    private static final TypeToken<Map<String, Object>> mapStringToObjectTypeToken = new TypeToken<Map<String, Object>>() {
    };

    private JSONObjectJsonDeserializer() {
    }

    static JsonDeserializer<JSONObject> getJsonObjectJsonDeserializer() {
        return jsonObjectJsonDeserializer;
    }

    @Override
    public JSONObject deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context) {
        // Convert the input jsonElement as if it were a Map<String, Object> (a generic representation for JSON objectS)
        final Map<String, Object> map = context.deserialize(jsonElement, mapStringToObjectTypeToken.getType());
        // And forward the map to the JSONObject constructor - it seems to accept it nice
        return new JSONObject(map);
    }

}