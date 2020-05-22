String strdate = "Fri Apr 04 06:55:24 GMT 2014";  
String currentPattern = "EEE MMM dd kk:mm:ss z yyyy";  
SimpleDateFormat sdf = new SimpleDateFormat( currentPattern, Locale.ENGLISH );

Date dt = sdf.parse( strdate ); // new date is constructed
System.out.println( dt );

String newPattern = "dd-MMM-yyyy";     // new pattern is defined  
sdf.applyPattern( newPattern );        // the same is applied
String new_strdate = sdf.format( dt ); // on the date object
System.out.println( new_strdate );     // resulting new string form of date