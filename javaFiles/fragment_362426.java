@Component
public class CalendarDeserialiser extends JsonDeserializer<Calendar>{

    TimeZone UTC = TimeZone.getTimeZone("UTC");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");

    @Override
    public Calendar deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        Calendar calendar;
        try{
            calendar = Calendar.getInstance(UTC);
            calendar.setTime(dateFormat.parse(p.getText()));
        }catch(Exception e){
            throw new IOException(e);
        }
        calendar.setTimeInMillis(p.getLongValue());
        return calendar;
    }
}