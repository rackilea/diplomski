public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(Example.class, new MySerializer());
    mapper.registerModule(module);
    System.out.println(mapper.writeValueAsString(list));
}

private static class MySerializer extends JsonSerializer<Example> {
    @Override
    public void serialize(Example value, JsonGenerator gen, SerializerProvider serializers)
                                                                      throws IOException {
        gen.writeStartObject();

        gen.writeFieldName("value");

        if (value.getType().equals("String")) {
            gen.writeString( value.getValue());
        } else {
            gen.writeRawValue(value.getValue());
        }

        gen.writeStringField("type", value.getType());
        gen.writeEndObject();
    }
}