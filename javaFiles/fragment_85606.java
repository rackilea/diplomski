D   Day in year     Number  189
d   Day in month    Number   10


SimpleDateFormat myFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",
                                                 Locale.US);
String myString = "Mon, 24 Nov 2014 00:20:41 +0000";
Date myDate = myFormat.parse(myString);
System.out.println(myDate);