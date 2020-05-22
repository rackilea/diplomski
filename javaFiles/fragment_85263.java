DateTimeZone tz = DateTimeZone.forID("Asia/Shanghai");

System.out.println(
  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
  .withZone(tz)
  .parseDateTime("1927-12-11 11:22:38"));
System.out.println(
  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
  .withZone(tz)
  .parseDateTime("1927-12-11 11:22:38")
  .toDate());

System.out.println(
  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
  .withZone(tz)
  .parseDateTime("1937-12-11 11:22:38"));
System.out.println(
  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
  .withZone(tz)
  .parseDateTime("1937-12-11 11:22:38")
  .toDate());