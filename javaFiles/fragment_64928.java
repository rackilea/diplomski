public class BackgroundService extends Service
{
    public BackgroundService(){
        super();
    }
    private BackgroundService mBS;

    // This is the object that receives interactions from clients.  See
    // RemoteService for a more complete example.
    private final IBinder mBinder = new LocalBinder();

     /**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
    public class LocalBinder extends Binder {
        BackgroundService getService() {
            return BackgroundService.this;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "in onBind()");
        return mBinder;
    }

}