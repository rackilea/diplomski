// Construct date and time objects
  Calendar dateCal = Calendar.getInstance();
  dateCal.setTime(date);
  Calendar timeCal = Calendar.getInstance();
  timeCal.setTime(time);

  // Extract the time of the "time" object to the "date"
  dateCal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
  dateCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
  dateCal.set(Calendar.SECOND, timeCal.get(Calendar.SECOND));

  // Get the time value!
  date = dateCal.getTime();