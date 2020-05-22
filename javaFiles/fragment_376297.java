String closingTime = "2101";
//getInstance() will return the current millis, so changes will be made relative to the current day and time
Calendar time = Calendar.getInstance();
// Calendar.HOUR_OF_DAY is in 24-hour format
time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(closingTime.substring(0, 2)));

// time.get(Calendar.MINUTE) returns the exact minute integer e.g for 10:04 will show 10:4
// For display purposes only We could just return the last two substring or format Calender.MINUTE as shown below
time.set(Calendar.MINUTE, Integer.parseInt(closingTime.substring(2, 4)));
String minute = String.format("%02d", time.get(Calendar.MINUTE));

// time.get(Calendar.AM_PM) returns integer 0 or 1 so let's set the right String value
String AM_PM = time.get(Calendar.AM_PM) == 0 ? "AM" : "PM";

// Calendar.HOUR is in 12-hour format
System.out.print("...\n" + time.get(Calendar.HOUR) + ":" + minute + " " + AM_PM);