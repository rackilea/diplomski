public void scheduleTestAlarmReceiver(Context context) {
    Intent receiverIntent = new Intent(context, MyAppReciever.class);
    PendingIntent sender = PendingIntent.getBroadcast(context, 123456789, receiverIntent, 0);
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 58);

    AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
            AlarmManager.INTERVAL_DAY, sender);
}