private static final TimeZone UTC = TimeZone.getTimeZone("Etc/UTC")

public static Calendar convertYYYYMMDDtoCalendar(String text) throws ParseException {        
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    format.setTimeZone(UTC);
    Calendar calendar = new GregorianCalendar(UTC);
    calendar.setDate(format.parse(text));
    return calendar;
}