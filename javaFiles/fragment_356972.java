public class MyKeyDeserializer extends KeyDeserializer {
    @Override
    public Entity2 deserializeKey(String key,
                                  DeserializationContext ctxt) throws IOException {
        return new Entity2(Long.parseLong(key));
    }
}

public class MyKeySerializer extends JsonSerializer<Entity2> {
    @Override
    public void serialize(Entity2 value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        gen.writeFieldName(value.getId().toString());
    }
}