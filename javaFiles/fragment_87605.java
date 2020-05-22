class CustomSerializer extends StdSerializer<SomeId>{

    protected CustomSerializer(Class<SomeId> t) {
        super(t);
    }

    @Override
    public void serialize(SomeId someId, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        gen.writeNumber(someId.getValue()); 
    }   
}