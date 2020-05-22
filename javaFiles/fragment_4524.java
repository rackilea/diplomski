MutableDateTime dateTime = new MutableDateTime();
System.out.println("CurrentTime " + dateTime);
dateTime.addMonths(-1); //last Month
dateTime.setMinuteOfDay(0);
dateTime.setSecondOfMinute(0);
dateTime.setHourOfDay(12);
dateTime.setDayOfMonth(1); //first Day of last Month     
System.out.println("first Day Time " + dateTime);

dateTime.setDayOfMonth(dateTime.dayOfMonth().getMaximumValue()); //set Day to last Day of that month
dateTime.setMinuteOfDay(59);
dateTime.setSecondOfMinute(59);
dateTime.setHourOfDay(23); //time set to night time 11:59:59

System.out.println("last Day Time " + dateTime);