private static class MyJsonDeserializer extends JsonDeserializer<LectureExternalLink> {
    @Override
    public LectureExternalLink deserialize(JsonParser p, DeserializationContext ctxt) 
                                                           throws IOException {
        String value = p.getValueAsString();
        LectureExternalLink val= new LectureExternalLink();
        val.setName(value);
        return val;
    }
}