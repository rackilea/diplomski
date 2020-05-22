public class BackgroundSyncService extends IntentService {

    public static final String NOTIFICATION = "com.example.sync.service";
public static final String RESULT = "result";

    public BackgroundSyncService() {
    super("BackgroundSyncService");
}

    @Override
protected void onHandleIntent(Intent intent) {
    //Do here what you want with your database

    //After all process you just notify your activitys
    Intent intent = new Intent(NOTIFICATION);
    intent.putExtra(RESULT, result);
sendBroadcast(intent);
    }

}