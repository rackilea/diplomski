Calendar cal = Calendar.getInstance();
Intent activate = new Intent(context, Alarm.class);
AlarmManager alarms ;
PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, activate, 0);
alarms = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
cal.set(Calendar.HOUR_OF_DAY, hour);
cal.set(Calendar.MINUTE, minute);
cal.set(Calendar.SECOND, 00);
alarms.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), alarmIntent);