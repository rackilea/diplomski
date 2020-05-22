public class NationJsonSerializer extends JsonSerializer<TNation> {

@Override
public void serialize(TNation value, JsonGenerator jgen, SerializerProvider provider) 
  throws IOException, JsonProcessingException {
    jgen.writeStartObject();
    jgen.writeNumberField("id", value.getId());
    jgen.writeStringField("name", value.getComune());
    jgen.writeStringField("iso", value.getCap());
    jgen.writeEndObject();
}
}