// Initial date time in String forma†
String timeOrg = "Mon Apr 18 22:56:10 GMT+05:30 2016";
// Corresponding date format
String dateTimeFormatOrg = "EEE MMM dd hh:mm:ss z yyyy";
// SimpleDateFormat using US locale to be able to parse "Mon Apr"
SimpleDateFormat sdfgmtOrg = new SimpleDateFormat(dateTimeFormatOrg, Locale.US);
// Parse the date 
Date time = sdfgmtOrg.parse(timeOrg);

// Target date format
String dateTimeFormat = "dd MMM yyyy hh:mm aa";
// SimpleDateFormat using the target locale
SimpleDateFormat sdfgmt = new SimpleDateFormat(dateTimeFormat, new Locale("hi","IN"));
// Set the Time Zone to UTC
sdfgmt.setTimeZone(TimeZone.getTimeZone("UTC"));
// Print the formatted date
System.out.println(sdfgmt.format(time))