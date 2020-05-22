Calendar future = Calendar.getInstance();
future.add(Calendar.HOUR_OF_DAY, enteredHour);
future.add(Calendar.MINUTE, enteredMinute);
future.add(Calendar.SECOND, enteredSecond);
//And so on...
//Now the calendar instance 'future' holds the current time plus the added values.