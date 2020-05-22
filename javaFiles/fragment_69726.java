String dateInString = "2016-09-18T12:17:21:000Z";
DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .append(DateTimeFormatter.ISO_DATE_TIME)
    .appendLiteral(':')
    .appendFraction(ChronoField.MILLI_OF_SECOND, 3, 3, false)
    .appendLiteral('Z')
    .toFormatter();
LocalDateTime instant = LocalDateTime.parse(dateInString, formatter);
ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Europe/Kiev"));
System.out.println(zonedDateTime);