public class Alarm extends BroadcastReceiver {
@Override
public void onReceive(Context context, Intent intent) {
    PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "");
    wl.acquire();

    Toast.makeText(context, "Alarm !!!!!!!!!!", Toast.LENGTH_LONG).show(); // For example
    sendNotification("Alarm",context);
    intent = new Intent();
    intent.setClass(context, AlarmActivity.class); //AlarmActivity is a dummy class name where to redirect
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.putExtra("msg","Task Pending");
    context.startActivity(intent);
    wl.release();
}