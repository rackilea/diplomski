public class NotificationReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if("NotificationReceived".equals(action)) {
            String msg = intent.getStringExtra("NotificationMessage");
            Log.v("shuffTest","msg" + msg);
        }
    }
}