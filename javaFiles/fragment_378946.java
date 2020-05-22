DateTimeZone timeZone = DateTimeZone.forID( "Asia/Kolkata" );
LocalTime now = LocalTime.now( timeZone ); // Adjust computer/JVM time zone's current time to desired time zone's current time.
LocalTime start = new LocalTime( "10:00:00" );
LocalTime stop = new LocalTime( "16:00:00" );
boolean isNotBeforeStart = ( ! now.isBefore( start ) );  // Is now equal to or after start?
boolean isBeforeEnd = now.isBefore( stop ); // Is now any time up to, but not including, stop?
boolean isWithinRange = ( isNotBeforeStart && isBeforeEnd );