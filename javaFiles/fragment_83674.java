String rfcDate = "Sat, 13 Mar 2010 11:29:05 -0800";
String pattern = "EEE, dd MMM yyyy HH:mm:ss Z";
SimpleDateFormat format = new SimpleDateFormat(pattern);
Date javaDate = format.parse(rfcDate);

//Done.