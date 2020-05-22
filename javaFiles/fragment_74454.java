public class CustomNullSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator jgen, 
           SerializerProvider provider) throws IOException {
        jgen.writeString("N/A");
    }
}