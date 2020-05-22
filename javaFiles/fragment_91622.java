//Your activity will respond to this action String
public static final String RECEIVE_PATH = "com.your.package.RECEIVE_JSON";

private BroadcastReceiver bReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(RECEIVE_PATH)) {
            String path = intent.getStringExtra("path");
            //Do something with the string
        }
    }
};
LocalBroadcastManager bManager;