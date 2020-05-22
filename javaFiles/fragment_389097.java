Date date = new Date();

DateFormat df = new SimpleDateFormat("HH:mm:ss");

// Tell the DateFormat that you want the time in this timezone
df.setTimeZone(TimeZone.getTimeZone("America/Montreal"));

String whatIWant = df.format(date);