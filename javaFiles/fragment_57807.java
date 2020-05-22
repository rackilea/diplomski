String input = "2013-10-02T00:00:00Z";
DateTimeZone timeZoneParis = DateTimeZone.forID( "Europe/Paris" );
DateTime dateTimeParis = new DateTime( input, timeZoneParis );
DateTime dateTimeMontréal = dateTimeParis.withZone( DateTimeZone.forID( "America/Montreal" ) );
DateTime dateTimeIndia = dateTimeParis.withZone( DateTimeZone.forID( "Asia/Kolkata" ) );
DateTime dateTimeUtc = dateTimeParis.withZone( DateTimeZone.UTC );

DateTimeFormatter formatter = DateTimeFormat.forStyle( "FF" ).withLocale( Locale.CANADA_FRENCH );