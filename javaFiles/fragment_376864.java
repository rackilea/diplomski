public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        WakeLock.acquire(context);
        // Timezone or time change
        if (intent.getAction() != null
            && (intent.getAction().equals(Intent.ACTION_TIME_CHANGED)
            || intent.getAction().equals(Intent.ACTION_TIMEZONE_CHANGED)))
        {
            calculateTimeZone(context);
        }
    }
}