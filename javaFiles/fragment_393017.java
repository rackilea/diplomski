String input = "24/giu/14";
DateTimeFormatter formatterInput = DateTimeFormat.forPattern( "dd/MMM/yy").withLocale( Locale.ITALY );
LocalDate localDate = formatterInput.parseLocalDate( input );
System.out.println( "localDate: " + localDate );

DateTimeFormatter formatterOutput = DateTimeFormat.forPattern( "dd/MM/yy").withLocale( Locale.ITALY ); // Locale not needed here, but it's a good habit to specify.
String output = formatterOutput.print( localDate );
System.out.println( "Output: " + output );