String tradeDate = "2017-06-01T15:49:18Z";

// create Calendar
Calendar cal = Calendar.getInstance();
// create formatter
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
// parse string and set the resulting date to Calendar
cal.setTime(df.parse(tradeDate));