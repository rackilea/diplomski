public class LocationService extends IntentService {
    ...
    public LocationService(StartActivity startActivity, DatabaseSQLite db, HomeFragment homeFragment) {
        super("Fused Location Service");
        ...
    }

   @Override
   public int onStartCommand(Intent intent, int flags, int startId) {

   // could also be in Broadcast Receiver etc..
   db = EventBus.getDefault().getStickyEvent(DatabaseSQLite.class); 

   ...
   return START_REDELIVER_INTENT;

    }
}