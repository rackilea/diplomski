public class MyActivity1 extends Activity
{
    private SocketDataReceiver socketDataReceiver;

    @Override
    protected void onResume() {
        super.onResume();
        socketDataReceiver = new SocketDataReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(
                socketDataReceiver, new IntentFilter(SocketThread.SOCKET_DATA_RECEIVED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(socketDataReceiver);
    }

    private class SocketDataReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            // intent contains your socket data,
            // get data from intent using SocketThread.SOCKET_DATA_IDENTIFIER
        }
    }
}