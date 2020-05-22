Intent intent = new Intent(this, AlarmReceiver.class);
PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
if (currentApiVersion >= 19)
    am.setWindow(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, 5000, alarmIntent);
else
    am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 86400000, alarmIntent);