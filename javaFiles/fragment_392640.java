public class PropertyValueSerializer extends JsonSerializer<Foo> {

    @Override
    public void serialize(Foo property_value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName(property_value.getKey());
        jsonGenerator.writeString(property_value.getValue());
        jsonGenerator.writeEndObject();
    }