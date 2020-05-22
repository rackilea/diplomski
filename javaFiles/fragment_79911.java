//SERVICE
private void sendMessage(String incomingMessage) {
    Intent intent = new Intent("UNIQUE_ACTION");
    intent.putExtra("incomingMessage", incomingMessage);
    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
}

public void run(){
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes; // bytes returned from read()

            // Keep listening to the InputStream until an exception occurs
            while (true) {
                // Read from the InputStream
                try {
                    bytes = mmInStream.read(buffer);
                    String incomingMessage = new String(buffer, 0, bytes);
                    Log.d(TAG, "InputStream: " + incomingMessage);
                    sendMessage(incomingMessage);

//ACTIVITY
@Override
public void onResume() {
    super.onResume();
    // This registers mMessageReceiver to receive messages.
    LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,new IntentFilter("UNIQUE_ACTION"));
}

// Handling the received Intents for the "UNIQUE_ACTION" event 
private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
@Override
public void onReceive(Context context, Intent intent) {
    // Extract data included in the Intent
    String incomingMessage = intent.getStringExtra()("incomingMessage");
    Log.d(TAG, incomingMessage);
    }
};

@Override
protected void onPause() {
    // Unregister since the activity is not visible
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    super.onPause();
}