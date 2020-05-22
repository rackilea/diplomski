java.sql.Date dateObj = new java.sql.Date(2014 - 1900, Calendar.FEBRUARY, 22);
Time timeObj = new Time(15, 0, 0);
Time midnight = new Time(0, 0, 0);
Date d = new Date(dateObj.getTime() + timeObj.getTime());

System.out.println("dateObj: " + dateObj + "/" + dateObj.getTime()); 
// dateObj: 2014-02-22/1393023600000, one hour less than a full day because of UTC-long

System.out.println("timeObj: " + timeObj + "/" + timeObj.getTime()); 
// timeObj: 15:00:00/50400000 => one hour less as UTC-long

System.out.println("midnight: " + midnight + "/" + midnight.getTime()); 
// midnight: 00:00:00/-3600000 => one hour less, negative!

System.out.println(new Date(dateObj.getTime())); // Sat Feb 22 00:00:00 CET 2014
System.out.println(new Date(timeObj.getTime())); // Thu Jan 01 15:00:00 CET 1970
System.out.println(d); // Sat Feb 22 14:00:00 CET 2014