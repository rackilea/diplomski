public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("PANKAJ", "Context class " + context.getClass().getName());
        Log.e("PANKAJ", "Application Context class "
                + context.getApplicationContext().getClass().getName());
    }
}