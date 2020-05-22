// Simulate input.
long millisecondsSinceEpoch = DateTime.now().getMillis();

// Proceed with a 'long' value in hand.
DateTime dateTimeUtc = new DateTime( millisecondsSinceEpoch, DateTimeZone.UTC );

DateTimeZone timeZone = DateTimeZone.forID( "Asia/Riyadh" );
DateTime dateTimeRiyadh = dateTimeUtc.withZone( timeZone );

// 'ar' = Arabic, 'SA' = Saudi Arabia.
java.util.Locale locale = new Locale( "ar", "SA" ); // ( language code, country code );
DateTimeFormatter formatter = DateTimeFormat.forStyle( "FF" ).withLocale( locale ).withZone( timeZone );
String output = formatter.print( dateTimeUtc );