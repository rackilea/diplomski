class PropertyListJSONSerializer extends StdSerializer<List<Property>> {

    public PropertyListJSONSerializer(JavaType type) {
        super(type);
    }

    @Override
    public void serialize(List<Property> value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeStartObject();
        for (Property p : value) {
            gen.writeStringField(p.getName(), p.getValue());
        }
        gen.writeEndObject();
    }
}