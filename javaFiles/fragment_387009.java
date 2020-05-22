DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy");
formatter.setLenient(false);
String dateStr = "Fri, 27 Dec 2013";
Date date = formatter.parse(dateStr);
Calendar calendar = Calendar.instance();
calendar.setTime(date);
// Get values from calendar.