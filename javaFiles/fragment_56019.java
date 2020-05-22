public class MySpecificClassSerializer extends JsonSerializer<MySpecificClass> {
    private final JsonSerializer<Object> defaultSerializer;

    public MySpecificClassSerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = checkNotNull(defaultSerializer);
    }

    @Override
    public void serialize(MySpecificClass value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        defaultSerializer.serialize(value, gen, serializers);
    }

    @Override
    public boolean isEmpty(SerializerProvider provider, MySpecificClass value) {
        return value.id == null;
    }
}