@JsonSerialize(using = ResponseSerializer.class)
public static enum Response {
...
class ResponseSerializer extends JsonSerializer<Response> {
    @Override
    public void serialize(Response value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeRaw(value.name());
    }
}