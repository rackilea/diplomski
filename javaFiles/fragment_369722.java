public static final String Broadcast_PLAY_NEW_AUDIO = "Some key so you know which broadcast is which";

//Create Receiver
private BroadcastReceiver receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
       //Do stuff
    }
};

//Register receiver
IntentFilter filter = new IntentFilter(HomeActivity.Broadcast_PLAY_NEW_AUDIO);
registerReceiver(receiver, filter);

//Send Broadcast
Intent broadcastIntent = new Intent(Broadcast_PLAY_NEW_AUDIO);
sendBroadcast(broadcastIntent);