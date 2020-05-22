public class DateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String msDateString = node.getValueAsText();

        if (msDateString == null || msDateString.length() == 0)
            return null;

        String unicodeDateString = msDateString.substring(msDateString.indexOf("(")+1);
        unicodeDateString = unicodeDateString.substring(0, unicodeDateString.indexOf(")"));
        Date date = new Date(Long.valueOf(unicodeDateString) * 1000);
        return date;
    }
}