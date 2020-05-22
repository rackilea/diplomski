Calendar cal = Calendar.getInstance();

cal.add(Calendar.MINUTE, "YourTimeinMinutes"); // you can use Calendar.Seconds etc according to your need

Intent intent = new Intent(YourActivity.this, AlarmReceiver.class);
PendingIntent sender = PendingIntent.getBroadcast(YourActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

// Get the AlarmManager service
AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);