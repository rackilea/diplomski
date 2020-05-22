Date date = new Date("01/01/2014");
Date date2 = new Date("01/07/2014");
Date date3 = new Date("07/07/2014");

Calendar cal = Calendar.getInstance(Locale.UK);
cal.setTime(date);
System.out.println(date + " " + cal.getTimeZone().inDaylightTime(date));
cal.setTime(date2);
System.out.println(date2 + " " + cal.getTimeZone().inDaylightTime(date2));
cal.setTime(date3);
System.out.println(date3 + " " + cal.getTimeZone().inDaylightTime(date3));