public class BarDeserializer extends JsonDeserializer<Bar> {
    @Override
    public Bar deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String text = p.getText();
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        return mapper.readValue(text, Bar.class);
    }
}