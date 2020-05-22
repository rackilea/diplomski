public static void main(String[] args) {
    compare(1800, 1, 1,  0, 0, 0);
    compare(1899,12,31, 23,59,59);
    compare(1900, 1, 1,  0, 0, 0);
    compare(1900,12,30, 23, 0, 0);
    compare(1921, 4,30,  0, 0, 0);
    compare(1921, 5, 1,  0, 0, 0);
    compare(1921, 5, 2,  0, 0, 0);
}
private static void compare(int year, int month, int day, int hour, int minute, int second) {
    Calendar calendar = new GregorianCalendar();
    calendar.clear();
    calendar.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
    calendar.set(year, month-1, day, hour, minute, second);
    Date date = calendar.getTime();

    ZonedDateTime zdt = ZonedDateTime.of(year, month, day, hour, minute, second, 0, ZoneId.of("Europe/Helsinki"));

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z XXX");
    sdf.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss z XXX");

    System.out.printf("%04d-%02d-%02d %02d:%02d:%02d   %s = %d   %s = %d   %d%n",
                      year, month, day, hour, minute, second,
                      sdf.format(date), date.getTime(),
                      dtf.format(zdt), zdt.toInstant().toEpochMilli(),
                      date.getTime() - zdt.toInstant().toEpochMilli());
}