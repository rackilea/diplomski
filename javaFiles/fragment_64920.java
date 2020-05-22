// works with Instant
Instant instant = Instant.now();
System.out.println(DateTimeFormatter.ISO_INSTANT.format(instant));

// works with ZonedDateTime 
ZonedDateTime zdt = ZonedDateTime.now();
System.out.println(zdt.format(DateTimeFormatter.ISO_INSTANT));

// example output
2014-09-02T08:05:23.653Z