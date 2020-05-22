class MyDatapointsDeserializer extends JsonDeserializer<List<List<Double>>> {

    private static final TypeReference<List<List<Double>>> TYPE_REF = 
            new TypeReference<List<List<Double>>>() {};

    @Override
    public List<List<Double>> deserialize(
            JsonParser jp, DeserializationContext ctxt) throws IOException {
        return jp.readValueAs(TYPE_REF);
    }
}