public class CNSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static final String LOG_TAG ="CNSyncService" ;
    private static CNSyncAdapter cnSyncAdapter = null;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(LOG_TAG, "onCreate");
        synchronized (sSyncAdapterLock) {
            if (cnSyncAdapter==null)
                cnSyncAdapter = new CNSyncAdapter(getBaseContext(),true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return cnSyncAdapter.getSyncAdapterBinder();
    }
}