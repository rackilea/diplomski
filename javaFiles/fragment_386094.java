long epochSeconds = … ;
Instant instant = Instant.ofEpochSeconds( epochSeconds );
ZoneId zoneId = ZoneId.of( "America/Montreal" );
ZonedDateTime zdt = ZonedDateTime.ofInstant( instant, zoneId);
Locale locale = Locale.CANADA_FRENCH;
DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL ).withLocale( locale );
String output = zdt.format( formatter );