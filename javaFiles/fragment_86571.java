public class MyReceiver extends BroadcastReceiver {    
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentService = new Intent(context, MyService.class);
        context.startService(intentService);
    }
}