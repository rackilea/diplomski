// Specify a time zone rather than rely on default.
DateTimeZone timeZone_Boston = DateTimeZone.forID( "America/New_York" );
DateTimeZone timeZone_London = DateTimeZone.forID( "Europe/London" );

DateTime dateTime_Boston = new DateTime( 2013, 10, 27, 22, 51, 12, timeZone_Boston );
DateTime dateTime_London = dateTime_Boston.toDateTime( timeZone_London ); 
DateTime earlier_London = dateTime_London.minusDays( 2 ); // Use '2' to get us before DST change.
DateTime earlier_UtcGmt = earlier_London.toDateTime( DateTimeZone.UTC );