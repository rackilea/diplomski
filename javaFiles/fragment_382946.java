TimeZone timezone = TimeZone.getTimeZone("GMT" + belt);
Calendar calendar = Calendar.getInstance(timezone);

DateFormat formatter = new SimpleDateFormat("HH:mm:ss z");
formatter.setCalendar(calendar);
formatter.setTimeZone(timezone);
String s = formatter.format(calendar.getTime());