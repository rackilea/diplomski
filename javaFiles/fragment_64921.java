// option a - parsed from the string
DateTimeFormatter f = DateTimeFormatter.ISO_DATE_TIME;
ZonedDateTime zdt = ZonedDateTime.parse("2014-09-02T08:05:23.653Z", f);

// option b - specified in the formatter - REQUIRES JDK 8u20 !!!
DateTimeFormatter f = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
ZonedDateTime zdt = ZonedDateTime.parse("2014-09-02T08:05:23.653Z", f);