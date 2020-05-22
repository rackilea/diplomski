public class GenderSerializer extends JsonSerializer<Gender> {

        public GenderSerializer() {
        }

        @Override
        public void serialize(Gender gender, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
               jgen.writeString(gender.getValue());        
        }
    }