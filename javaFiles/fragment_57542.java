public static String CalculateUTC_Time(String Date, String Time) {
    String X[] = Time.split(":");

    int Hours = Integer.parseInt(X[0]);
    int Minutes = Integer.parseInt(X[1]);

    LocalDate date = new LocalDate(Date);
    LocalTime time = new LocalTime(Hours, Minutes);
    DateTime dt = date.toDateTime(time);

    SimpleDateFormat f2 = new SimpleDateFormat("HH:mm");
    f2.setTimeZone(TimeZone.getTimeZone("UTC"));
    return (f2.format(dt.toDate()));
}