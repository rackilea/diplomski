Long alertTime = nextAlarm.getTimeInMillis();
    Intent alertIntent = new Intent(this, AlertReceiver.class);

//ADD THIS
final PendingIntent pIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

 alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, AlarmManager.INTERVAL_HALF_HOUR, pIntent);

    // REMOVE THIS: 
   alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
            PendingIntent.getBroadcast(this, 1, alertIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT));