public class autostart extends BroadcastReceiver 
{
    public void onReceive(Context context, Intent arg1) 
    {
        Intent intent = new Intent(context,service.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
        Log.i("Autostart", "started");
    }
}