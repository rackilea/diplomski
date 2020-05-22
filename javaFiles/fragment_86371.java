class OmitListTypeJsonDeserializer extends CollectionDeserializer {

    public OmitListTypeJsonDeserializer(CollectionDeserializer src) {
        super(src);
    }

    @Override
    public Collection<Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        p.nextToken(); // Omit array type
        p.nextToken(); // Omit comma and start array

        Collection<Object> collection = super.deserialize(p, ctxt);

        p.nextToken(); // Omit end of array

        return collection;
    }

    @Override
    public CollectionDeserializer createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        return new OmitListTypeJsonDeserializer(super.createContextual(ctxt, property));
    }
}