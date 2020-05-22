// Code for your method.
YearMonth yearMonth = year.atMonth ( month ); // Instantiate a YearMonth from a Year and a Month.
LocalDate localDate = yearMonth.atDay ( 1 ); // First day of month.
ZoneId zoneId = ZoneId.systemDefault (); // Or… ZoneId.of("America/Montreal");
ZonedDateTime zdt = localDate.atStartOfDay ( zoneId );
long millis = zdt.toInstant ().toEpochMilli ();