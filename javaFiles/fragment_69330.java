// don't use the Calendar class, you surely want the gregorian calendar
GregorianCalendar calendar = new GregorianCalendar(2014, 02, 20, 9, 30, 00); // not 14!!!

// getting time zone via zone name PST which is not unique, it could also stand for 
// Pakistan Standard Time, try to use "America/Los_Angeles" (more reliable)
TimeZone tz = TimeZone.getTimeZone("PST");
calendar.setTimeZone(tz);

// output of java.util.Date#toString() depends on local time zone (my case Europe/Berlin => CET)
System.out.println(calendar.getTime()); // Tue Mar 20 18:30:00 CET 14

// PST is 8 hours behind UTC and 9 hours behind CET
System.out.println("PST: " + tz.getRawOffset() / 3600000);

// correct output in PST-zone with your wish format
SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
sdf.setTimeZone(tz);
System.out.println(sdf.format(calendar.getTime()));