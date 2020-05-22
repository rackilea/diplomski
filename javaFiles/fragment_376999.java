Calendar cal = Calendar.getInstance();

Intent intent = new Intent(this, MyService.class);
PendingIntent pintent = PendingIntent.getService(this, 0, intent, 0);

AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
// Start every 30 seconds
alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30*1000, pintent);