DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");

String originalDateValue = "12-09-2012 02:33:00";
Date originalDate = formatter1.parse( originalDateValue );

String shortDateValue = formatter2.format( originalDate );
Date shortDate = formatter2.parse( shortDateValue );

System.out.println( originalDateValue );
System.out.println( originalDate );

System.out.println( shortDateValue );
System.out.println( shortDate );