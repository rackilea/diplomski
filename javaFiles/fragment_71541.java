// A formatter that prints the timezone offset
SimpleDateFormat df = new SimpleDateFormat("Z");    

// Current date+time in system default timezone.
Calendar now = Calendar.getInstance();

// Don't forget this if you use a timezone other than system default:
df.setTimeZone( now.getTimeZone() );

// Create the result
String result = "/Date(" now.getTimeInMillis() + df.format(now.getTime()) +")/";