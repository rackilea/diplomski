public class Alarm extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {
    MediaPlayer mp = MediaPlayer.create(context, R.raw.ferry_sound);
    mp.start();
    PowerManager pm = (PowerManager)     context.getSystemService(Context.POWER_SERVICE);
    PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
    wl.acquire();
    Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    long[] s = { 0, 100, 10, 500, 10, 100, 0, 500, 10, 100, 10, 500 };
    vibrator.vibrate(s, -1);
 }
}