public class DescriptionSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if(value.length()>100){
            gen.writeString(value.substring(0, 100)+"...");
        }

    }

}