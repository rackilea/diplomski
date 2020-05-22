public class ObjectIdSerializer extends SerializerBase<ObjectId> {

    protected ObjectIdSerializer(Class<ObjectId> t) {
        super(t);
    }

    public ObjectIdSerializer() {
        this(ObjectId.class);
    }

    @Override
    public void serialize(ObjectId value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        jgen.writeString(value.toString());
    }
}