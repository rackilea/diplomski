BackgroundService mBackgroundService;
boolean mServiceBound = false;

private ServiceConnection mServiceConnection = new ServiceConnection() {


@Override
public void onServiceDisconnected(ComponentName name) {
    mServiceBound = false;
}

@Override
public void onServiceConnected(ComponentName name, IBinder service) {
    LocalBinder  myBinder = (LocalBinder ) service;
    mBackgroundService = myBinder.getService();
    mServiceBound = true;
}
};
     //Start the service when the activity starts
     @Override
protected void onStart() {
    super.onStart();
    Intent intent = new Intent(this, BackgroundService.class);
    startService(intent);
    bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
}

@Override
protected void onStop() {
    super.onStop();
    if (mServiceBound) {
        unbindService(mServiceConnection);
        mServiceBound = false;
    }
}