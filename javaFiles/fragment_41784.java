DateFormat fullMonthFormat = new SimpleDateFormat("MMMM");
DateTime dt1 = new DateTime();
DateTimeZone dtz = DateTimeZone.forID("America/New_York");
dt1 = dt1.withZone(dtz);
fullMonthFormat.setTimeZone(dtz.toTimeZone());
System.out.println(fullMonthFormat.format(dt1.toDate()));