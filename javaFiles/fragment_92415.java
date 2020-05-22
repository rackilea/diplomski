public class TryJsonStringSerializer extends JsonSerializer<String> {

    private RawSerializer<String> rawSerializer = new RawSerializer<String>(String.class);
    private ToStringSerializer stringSerializer = ToStringSerializer.instance;

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) 
            throws IOException, JsonProcessingException {
        if (value == null) {
            return;
        }
        value = value.trim();
        if (value.startsWith("{") && value.endsWith("}")) {
            rawSerializer.serialize(value, jsonGenerator, serializerProvider);
        } else {
            stringSerializer.serialize(value, jsonGenerator, serializerProvider);
        }
    }

}