DateTime dateTime = new DateTime( 1390276603054L );

DateTime dateTimeSpain = dateTime.toDateTime( DateTimeZone.forID( "Europe/Madrid" ) );
DateTime dateTimeIndia = dateTime.toDateTime( DateTimeZone.forID( "Asia/Kolkata" ) );
DateTime dateTimeUtcGmt = dateTime.toDateTime( DateTimeZone.UTC );

// For database.
java.sql.Timestamp timestamp = new java.sql.Timestamp( dateTimeSpain.getMillis() );