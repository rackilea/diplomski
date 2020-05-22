public class NullSerializer extends JsonSerializer<Object> {
  public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    // any JSON value you want...  
    jgen.writeString("");
  }
}