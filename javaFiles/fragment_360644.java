public class RawJsonListJacksonSerializer extends JsonSerializer<List<String>> {
    @Override
    public void serialize(List<String> entries, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();

        for (int i=0; i<entries.size(); i++) {
            jsonGenerator.writeRaw(entries.get(i) == null ? "null" : entries.get(i));
            if (i<entries.size()-1) jsonGenerator.writeRaw(",");
        }

        jsonGenerator.writeEndArray();
    }
}