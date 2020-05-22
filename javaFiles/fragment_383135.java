class UnitIntStdScalarDeserializer extends StdScalarDeserializer<Integer> {

    private StdScalarDeserializer<Integer> src;

    public UnitIntStdScalarDeserializer(StdScalarDeserializer<Integer> src) {
        super(src);
        this.src = src;
    }

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        String[] parts = value.split("\\s+");
        if (parts.length == 2) {
            return Integer.valueOf(parts[0]);
        }
        return src.deserialize(p, ctxt);
    }
}