String myDateString = "13:24:40";
//SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//the above commented line was changed to the one below, as per Grodriguez's pertinent comment:
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
Date date = sdf.parse(myDateString);

Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
calendar.setTime(date);   // assigns calendar to given date 
int hour = calendar.get(Calendar.HOUR);
int minute; /... similar methods for minutes and seconds