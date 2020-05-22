final TimeZone tz = TimeZone.getTimeZone("GMT");
 ......
// thread 1 SimpleDateFormat instance
sdf.setTimeZone(tz);

// thread 2 SimpleDateFormat instance
sdf.setTimeZone(tz);