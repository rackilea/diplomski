DateTimeFormatter iso = ISODateTimeFormat.dateTimeParser().withOffsetParsed();
DateTime tsp = iso.parseDateTime("2018-07-24T15:30:00-07:00");

DateTimeFormatter out = DateTimeFormat.forPattern("h:mma").withLocale(Locale.ENGLISH);

System.out.println(tsp); // 2018-07-24T15:30:00.000-07:00
System.out.println(out.print(tsp).toLowerCase()); // 3:30pm