AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context
        .ALARM_SERVICE);
Intent alarmIntent = new Intent(context, BlockchainService.class);
// customize your intent
PendingIntent pendingIntent = PendingIntent.getService(context, 0,
        alarmIntent, 0);
alarmManager.set(AlarmManager.RTC_WAKEUP, your_specific_time, pendingIntent);