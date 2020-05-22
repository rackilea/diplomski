hours = timePicker.getCurrentHour();
minutes = timePicker.getCurrentMinute();

Calendar cal = Calendar.getInstance();
cal.setTimeInMillis(System.currentTimeMillis());
cal.set(Calendar.HOUR_OF_DAY, hours);
cal.set(Calendar.MINUTE, minutes);

alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), PendingIntent.getBroadcast(MainMenu.this, 1, intentAlarm,
    PendingIntent.FLAG_UPDATE_CURRENT));