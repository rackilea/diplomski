public class MapKeySerializer extends SerializerBase<Object> {
    private static final SerializerBase<Object> DEFAULT = new StdKeySerializer();
    private static final ObjectMapper mapper = new ObjectMapper();

    protected MapKeySerializer() {
    super(Object.class);
    }

    @Override
    public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
    return DEFAULT.getSchema(provider, typeHint);
    }

    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
    if (null == value) {
        throw new JsonGenerationException("Could not serialize object to json, input object to serialize is null");
    }
    StringWriter writer = new StringWriter();
    mapper.writeValue(writer, value);
    jgen.writeFieldName(writer.toString());
    }
}