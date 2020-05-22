Calendar time = Calendar.getInstance();

//Calendar.HOUR_OF_DAY is in 24-hour format
time.set(Calendar.HOUR_OF_DAY, closingTime.substring(0,2));

time.set(Calendar.MINUTE, closingTime.substring(2,4));

//Calendar.HOUR is in 12-hour format
System.out.print(time.get(Calendar.HOUR) + ":" + time.get(Calendar.MINUTE) + " " + time.get(Calendar.AM_PM));