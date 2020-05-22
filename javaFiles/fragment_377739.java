public static boolean isNowBetweenRange(String t1, String t2) {    
  DateTime time1 = normalizeString(t1);
  DateTime time2 = normalizeString(t2);

  Interval interval = new Interval(time1, time2);

  return interval.contains(DateTime.now());
}

private static final DateTimeFormatter FORMAT =
                  ISODateTimeFormat.timeNoMillis().withOffsetParsed();

private static DateTime normalizeString(String t1) {
  DateTimeZone zone = FORMAT.parseDateTime(t1).getZone();
  return FORMAT
      .parseLocalTime(t1)
      .toDateTimeToday(zone);
}