//IN YOUR ACTIVITY 
startService(new Intent(getApplicationContext(), BluetoothService.class));
bindService(new Intent(getApplicationContext(), BluetoothService.class), mServiceConnection, Context.BIND_AUTO_CREATE);


private ServiceConnection mServiceConnection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BluetoothService.BackgroundBinder backgroundBinder = (BluetoothService.BackgroundBinder) iBinder;
        mBackgroundService = backgroundBinder.getBackgroundService();
        startPinging();
}

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mBackgroundService = null;
        }
};

//IN SERVICE
public class BluetoothBinder extends Binder {
    public BluetoothService getBluetoothService() {
        return BluetoothService.this;
    }
}

@Override
public IBinder onBind(Intent intent) {
    Log.d(TAG, "Inside onBind");
    return new BluetoothBinder();
}