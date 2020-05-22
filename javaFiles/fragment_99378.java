public static void main(String[] args) throws ParseException {
    TimeZone utc = TimeZone.getTimeZone("UTC");
    DATE_FORMAT.setTimeZone(utc);
    DATE_FORMAT_WITH_WEEK.setTimeZone(utc);
    Calendar calendar = Calendar.getInstance(utc);
    calendar.setTime(DATE_FORMAT.parse("1900-01-01"));
    Calendar futureDate = Calendar.getInstance(utc);
    futureDate.setTime(DATE_FORMAT.parse("2020-12-31"));
    ...
}