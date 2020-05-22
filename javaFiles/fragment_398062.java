TimeZone.setDefault(null);
System.clearProperty​("user.timezone"); //04/26/2019 EDIT This was suggested as a cleaner way of clearing the user timezone in the system.
//(above) force fetches and sets the JVM to the timezone the system is set to
System.out.println("Zone: "+ZoneId.systemDefault()+" isDaylightsavings? "+ZoneId.systemDefault().getRules().isDaylightSavings(Instant.now())+" currentDateTime: "+currentDateTime);
String timeZone = ""+ZoneId.systemDefault();
Calendar selectedDate = Calendar.getInstance(TimeZone.getTimeZone(timeZone)); // important when it comes to determining PDT or PST
date = selectedDate.getTime();