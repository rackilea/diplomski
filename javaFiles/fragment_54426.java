// formatter - use English locale for month and day of week
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

// current date/time in New York timezone
ZonedDateTime nowNy = ZonedDateTime.now(ZoneId.of("America/New_York"));
// convert to another timezone (US/Central)
ZonedDateTime nowCentral = nowNy.withZoneSameInstant(ZoneId.of("US/Central"));

// format dates
System.out.println(fmt.format(nowNy) + "--" + fmt.format(nowCentral));