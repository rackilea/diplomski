TimeZone tz = TimeZone.getTimeZone( "America/Los_Angeles" );
Locale locale = Locale.US;
GregorianCalendar gc = new GregorianCalendar( tz , locale );
gc.set( 2018 , 9- 1 , 3 , 0 , 0 , 0 );  // Subtract 1 from month number to account for nonsensical month numbering used by this terrible class.
gc.set( Calendar.MILLISECOND , 0 ); // Clear fractional second.
System.out.println( "gc (original): " + gc.toString() );
System.out.println( gc.toZonedDateTime() + "\n" );  // Generate a more readable string, using modern java.time classes. Delete this line if running on Android <26. 

int week = 10;
gc.set( Calendar.WEEK_OF_YEAR , week );
System.out.println( "gc (week=10): " + gc.toString() );
System.out.println( gc.toZonedDateTime() + "\n" );

int weekAfter = ( week + 1 );
gc.set( Calendar.WEEK_OF_YEAR , weekAfter );
System.out.println( "gc (weekAfter): " + gc.toString() );
System.out.println( gc.toZonedDateTime() + "\n" );