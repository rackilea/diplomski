public class OrderTypeSerializer extends JsonSerializer<OrderType> {

  @Override
  public void serialize(OrderType value, JsonGenerator generator,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {

    generator.writeStartObject();
    generator.writeFieldName("id");
    generator.writeNumber(value.getId());
    generator.writeFieldName("name");
    generator.writeString(value.getName());
    generator.writeEndObject();
  }
}