LocalTime timeInAM=new LocalTime(hourOfDay, minuteOfHour);
LocalTime timeOutAM=new LocalTime(hourOfDay, minuteOfHour);
LocalTime timeInPM=new LocalTime(hourOfDay, minuteOfHour);
LocalTime timeOutPM=new LocalTime(hourOfDay, minuteOfHour);

LocalTime amInterval = timeOutAM.minusHours(timeInAM.getHourOfDay()).minusMinutes(timeInAM.getMinuteOfHour());
LocalTime pmInterval = timeOutPM.minusHours(timeInPM.getHourOfDay()).minusMinutes(timeInPM.getMinuteOfHour());

LocalTime total = pmInterval.plusHours(amInterval.getHourOfDay()).plusMinutes(amInterval.getMinuteOfHour());