public class TimerReceiverSyncInterval extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        scheduleAlarms(context);
        context.startService(new Intent(context, NotificationServiceSyncInterval.class));
        Log.d("TAG", "Sync OnReceive");
    }

    public static void scheduleAlarms(Context paramContext) {
        Calendar calendar = Calendar.getInstance();
        AlarmManager localAlarmManager = (AlarmManager) paramContext.getSystemService(Context.ALARM_SERVICE);
        PendingIntent localPendingIntent = PendingIntent.getService(paramContext, 0,
            new Intent(paramContext, NotificationServiceSyncInterval.class), PendingIntent.FLAG_UPDATE_CURRENT);

        localAlarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(),
               (1 * 60000), localPendingIntent);
    }
}