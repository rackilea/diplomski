class ReplaceMapValueJsonDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) {
        return null;
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt, Object intoValue) throws IOException {
        Map replacementValues = getCurrentReplacementValues(ctxt);
        //...

        return super.deserialize(p, ctxt, intoValue);
    }

    private Map<String, Object> getCurrentReplacementValues(DeserializationContext ctxt) {
        try {
            Object value = ctxt.findInjectableValue("replacementValues", null, null);
            return (Map<String, Object>) value;
        } catch (JsonMappingException ie) {
            return Collections.emptyMap();
        }
    }
}