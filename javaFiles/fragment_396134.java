private ServiceConnection mConnection = new ServiceConnection() {
    public void onServiceConnected(ComponentName className, IBinder service) {
        IBackgroundService yourService = IBackgroundService.Stub.asInterface(service);

        // calls to yourService.queueMsg(...)
    }

    public void onServiceDisconnected(ComponentName className) {
        Log.e(TAG, "Service has unexpectedly disconnected");
    }
};