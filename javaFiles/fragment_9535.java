class ModelSerializer extends JsonSerializer<Model> {

    @Override
    public void serialize(Model model, JsonGenerator generator, SerializerProvider serializers) throws IOException {
      generator.writeStartObject();

      JsonSerializer<Object> componentSerializer = serializers.findValueSerializer(getClass());
      JsonSerializer<Object> unwrappingSerializer = componentSerializer.unwrappingSerializer(NameTransformer.NOP);
      unwrappingSerializer.serialize(this, generator, serializers);

      generator.writeEndObject();
    }
  }