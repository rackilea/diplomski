class SocketThread implements Runnable
{
    static final String SOCKET_DATA_RECEIVED = "com.your.package.SOCKET_DATA_RECEIVED";
    static final String SOCKET_DATA_IDENTIFIER = "com.your.package.SOCKET_DATA";
    private Context context;

    SocketThread(Context c) {
        context = c.getApplicationContext();
    }

    @Override
    public void run() { // code running in your thread
        // fetch data from socket ...
        Intent intent = new Intent();
        intent.putExtra(SOCKET_DATA_IDENTIFIER, data); // store data in your intent
        // send data to registered receivers
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        // your code ...
    }
}