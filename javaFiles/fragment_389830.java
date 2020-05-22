public class RingtonePlayingService extends Service {
private static final String TAG = RingtonePlayingService.class.getSimpleName();
private static final String URI_BASE = RingtonePlayingService.class.getName() + ".";
public static final String ACTION_DISMISS = URI_BASE + "ACTION_DISMISS";


private Ringtone ringtone;

@Override
public IBinder onBind(Intent intent) {
    return null;
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(TAG, "onStartCommand");

    if (intent == null) {
        Log.d(TAG, "The intent is null.");
        return START_REDELIVER_INTENT;
    }

    String action = intent.getAction();

    if (ACTION_DISMISS.equals(action))
        dismissRingtone();
    else {
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(this, alarmUri);
        ringtone.play();
    }

    return START_NOT_STICKY;
}

public void dismissRingtone() {
    // stop the alarm rigntone
    Intent i = new Intent(this, RingtonePlayingService.class);
    stopService(i);

    // also dismiss the alarm to ring again or trigger again
    AlarmManager aManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
    aManager.cancel(pendingIntent);

    // Canceling the current notification
    NotificationManager notificationManager =
            (NotificationManager)getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
    notificationManager.cancel(321);
}

@Override
public void onDestroy() {
    ringtone.stop();
}}