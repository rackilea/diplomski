public class IsoDateSerializer extends JsonSerializer<DateTime> {
    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) {
        String isoDate = ISODateTimeFormat.dateTime().print(value);
        jgen.writeRaw("ISODATE(\"" + isoDate + "\")");
    }