class ForceIntSerializer extends StdScalarSerializer<Object> {

    public ForceIntSerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value instanceof String) {
            try {
                gen.writeNumber(Integer.parseInt(value.toString()));
            } catch (NumberFormatException e) {
                gen.writeString(value.toString());
            }
        } else if (value instanceof Integer) {
            gen.writeNumber(((Integer) value));
        }
    }
}