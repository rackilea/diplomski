public void setDailyAlarms(Context context){

    // Daily Alarm

    AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 8);
    calendar.set(Calendar.MINUTE, 0);
    Intent intent = new Intent("DAIL_ALARM_TRIGGERED");
    PendingIntent pIntent = PendingIntent.getBroadcast(context,
            100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    manager.setRepeating(AlarmManager.RTC_WAKEUP,
            calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pIntent);




}

public void setRepeatingAlarm(Context context){
        // Alarm 30 min each'

        AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent("REPEATING_ALARM_TRIGGERED");
        PendingIntent pIntent = PendingIntent.getBroadcast(context,
                102, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        manager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(), 30*60*1000, pIntent);
}

public void cancelRepeatingAlarm(Context context){
    AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent("REPEATING_ALARM_TRIGGERED");
    PendingIntent pIntent = PendingIntent.getBroadcast(context,
            102, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    manager.cancel(pIntent);
}