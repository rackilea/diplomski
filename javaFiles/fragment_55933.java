public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

    /**
     * This method is called when we are waking up by AlarmManager
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "pulse app");
        //Acquire the lock
        wl.acquire();

        //You can do the processing here.

        //Release the lock
        wl.release();
    }

    /**
     * Register our app with AlarmManager to start receiving intents from AlarmManager
     */
    public static void setAlarm(Context context)
    {
        int interval = 10; // delay in secs
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval*1000 , pi);
    }

    /**
     * Unregister the app with AlarmManager, call this to stop receiving intents from AlarmManager
     */
    public static void cancelAlarm(Context context)
    {
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

}