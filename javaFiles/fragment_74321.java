public class TimestampDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jsonParser.getValueAsLong());
        return calendar.getTime();
    }
}