class Result {
    @JsonRawValue
    @JsonSerialize(using = ToPrettyJsonSerializer.class)
    private String content;
}

private static class ToPrettyJsonSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String string, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        Object json = new ObjectMapper().readValue(string, Object.class);
        gen.writeObject(json);
    }
}