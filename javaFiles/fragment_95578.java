DateTimeFormatter dtf = 
  new DateTimeFormatterBuilder()
  .parseStrict()
  .appendPattern("uuuu-MM-dd'T'HH:mm:ssXXX'['VV']'").toFormatter();
ZonedDateTime d = ZonedDateTime.parse("2015-06-17T12:55:33+05:00[Europe/Amsterdam]", dtf);
System.out.println(d.toString()); // 2015-06-17T12:55:33+02:00[Europe/Amsterdam]