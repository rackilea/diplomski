public class PowerConnectionReceiver extends BroadcastReceiver {

    public static final String ACTION_STATUS_CHANGE = "STATUS_CHANGE";
    public static final String EXTRA_STATUS = "POWER_STATUS";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String status = null;
        if(action.equals(Intent.ACTION_POWER_CONNECTED)){
            status = "Connected";
        }
        else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
           status = "Disconnected";
        }

        if (status == null){
            return;
        }

        Intent intent = new Intent(ACTION_STATUS_CHANGE);
        // You can also include some extra data.
        intent.putExtra(EXTRA_STATUS, status);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}