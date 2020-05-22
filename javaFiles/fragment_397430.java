// set the formatter to UTC
TimeZone utc = TimeZone.getTimeZone("UTC");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
sdf.setTimeZone(utc);

// parse and set the time to midnight
Calendar cFrom = Calendar.getInstance(utc);
cFrom.setTime(sdf.parse("2017-07-05"));
cFrom.set(Calendar.HOUR_OF_DAY, 0);
cFrom.set(Calendar.MINUTE, 0);
cFrom.set(Calendar.SECOND, 0);
cFrom.set(Calendar.MILLISECOND, 0);

// parse and set the time to 23:00
Calendar cTo = Calendar.getInstance(utc);
cTo.setTime(sdf.parse("2017-07-08"));
cTo.set(Calendar.HOUR_OF_DAY, 23);
cTo.set(Calendar.MINUTE, 0);
cTo.set(Calendar.SECOND, 0);
cTo.set(Calendar.MILLISECOND, 0);

// get the epoch second (get millis and divide by 1000)
long start = cFrom.getTimeInMillis() / 1000;
long end = cTo.getTimeInMillis() / 1000;