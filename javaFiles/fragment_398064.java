public class MainActivity extends Activity
{
private CustomService mService = null;

private boolean mIsBound;

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    startService(new Intent(this.getBaseContext(), CustomService.class));
    doBindService();
}


private ServiceConnection mConnection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder)
    {
        mService = ((CustomService.LocalBinder)iBinder).getInstance();
        mService.setHandler(yourHandler);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName)
    {
        mService = null;
    }
};

private void doBindService()
{
    // Establish a connection with the service.  We use an explicit
    // class name because we want a specific service implementation that
    // we know will be running in our own process (and thus won't be
    // supporting component replacement by other applications).
    bindService(new Intent(this,
            CustomService.class), mConnection, Context.BIND_AUTO_CREATE);
    mIsBound = true;
}

private void doUnbindService()
{
    if (mIsBound)
    {
        // Detach our existing connection.
        unbindService(mConnection);
        mIsBound = false;
    }
}

@Override
protected void onDestroy()
{
    super.onDestroy();
    doUnbindService();
}