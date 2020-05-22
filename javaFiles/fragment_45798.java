private static class MySerializer extends JsonSerializer<Example> {
    private static final ObjectMapper internalMapper = new ObjectMapper();

    @Override
    public void serialize(Example value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ObjectNode node = internalMapper.valueToTree(value);

        if (value.getType().equals("String")) {
            node.put("value", value.getValue());
        } else {
            node.putRawValue("value", new RawValue(value.getValue()));
        }

        gen.writeObject(node);
    }
}