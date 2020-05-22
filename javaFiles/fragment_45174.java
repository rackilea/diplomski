public class JsonDateOnlyDeserializer extends JsonDeserializer<Date> {
    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = jp.getText();
        try {
            return dateFormat.parse(dateString);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}