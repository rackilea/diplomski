public class XMLCalendarSerializer extends StdSerializer<XMLGregorianCalendar> {
    public XMLCalendarSerializer() {
        this((Class)null);
    }

    public XMLCalendarSerializer(Class<XMLGregorianCalendar> t) {
        super(t);
    }

   public void serialize(XMLGregorianCalendar value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        DateFormat dateFormatt = provider.getConfig().getDateFormat();
        if(dateFormatt.getCalendar() == null) {
            jgen.writeString(value.toString());
        } else {
            SimpleDateFormat dateFormat = (SimpleDateFormat)dateFormatt;
            GregorianCalendar a = value.toGregorianCalendar();
            Date date = value.toGregorianCalendar().getTime();
            dateFormat.setTimeZone(TimeZone.getTimeZone(value.getTimeZone(value.getTimezone()).getDisplayName()));
            jgen.writeString(dateFormat.format(date));
        }

    }
}