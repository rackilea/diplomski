DateTimeFormatter f = DateTimeFormatter.ofPattern( "kk:mm" );
LocalTime lt = LocalTime.MIN;
String output = lt.format( f );

System.out.println( lt.toString() );  // Standard ISO 8601 format, 00-24.
System.out.println( output );         // `kk` format is 24, 1 , 2, … , 22 , 23.