LocalDate ld = LocalDate.of( 2017 , 1 , 23 );
LocalTime lt = LocalTime.of( 12 , 23 ) ;
ZoneId z = ZoneId.of( "America/Montreal" );
ZonedDateTime zdt = ZonedDateTime.of( ld , lt , z );

Locale l = Locale.CANADA_FRENCH ;
DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.LONG ).withLocale( l );
String output = zdt.format( f );