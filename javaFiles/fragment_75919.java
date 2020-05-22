DateTimeZone dtz = DateTimeZone.forID("America/Denver");
DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ").withZone(dtz);

DateTime f = fmt.parseDateTime("2014-09-20T20:00:33+07:00");
System.out.println("JODA-DT=" + f); // 2014-09-20T07:00:33.000-06:00
System.out.println("STD-OFFSET=" + dtz.getStandardOffset(f.getMillis()) / 3600000); // -7
f = f.withZone(DateTimeZone.forOffsetMillis(dtz.getStandardOffset(f.getMillis())));
System.out.println("Standard-time=" + f); // 2014-09-20T06:00:33.000-07:00