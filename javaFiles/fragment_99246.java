String timeZoneValue = request.getParameter("timeZone");
timeZoneValue = Long.valueOf(timeZone).longValue(); // convert string to long value.
// get the calendar instances
Calendar cal = Calendar.getInstance();
cal.setTime(time); // set the time which get from DB
cal.add(Calendar.MINUTE, timeZoneValue.intValue() * 60); // added the timezone offset.
// formatting  the time
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");  
parseTime = simpleDateFormat.format(cal.getTime()); 
Date newDate = simpleDateFormat.parse(parseTime);