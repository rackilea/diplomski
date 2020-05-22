public class CustomDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {

        String text = jp.getText();
        if (text == null || text.isEmpty()) {
            return null;
        } else {
            return Double.valueOf(text);
        }
    }
}