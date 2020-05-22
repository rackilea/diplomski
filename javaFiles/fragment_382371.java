@Override
public int onStartCommand(Intent intent, int flags, int startId) {

//In this part i connected whith Bluetooth.

    new Handler().post(new Runnable() {
        @Override
        public void run() {
            byte[] buffer = new byte[2500];
            int bytes;
        while (true) {
        try {
            bytes = mmInStream.read(buffer); 
                        String readMessage = new String(buffer, 0, bytes);
                    sendMessage(readMessage);
        } catch (IOException e) { }
        }
    });
}

private void sendMessage(String Msg) {
  Intent intent = new Intent("custom-event-name");
  intent.putExtra("message", Msg);
  LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
}