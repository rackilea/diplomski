public class DateTimeXmlAdapter extends XmlAdapter<String, DateTime> {
    private static final DateTimeFormatter formatter = 
        ISODateTimeFormat.dateTimeNoMillis().withZoneUTC();

    @Override
    public DateTime unmarshal(String value) {
        return formatter.parseDateTime(value);
    }

    @Override
    public String marshal(DateTime value) {
        return formatter.print(value);
    }
}