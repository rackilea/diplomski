// change 60 minutes to 59 (otherwise it doesn't work)
String timeDateStr = "2017-18-08 12:59:30.345";
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss.SSS");
// parse to LocalDateTime
LocalDateTime dt = LocalDateTime.parse(timeDateStr, dtf);

// assume the LocalDateTime is in UTC
Instant instant = dt.toInstant(ZoneOffset.UTC);
System.out.println(instant.toEpochMilli());