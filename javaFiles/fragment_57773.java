public class NotificationServiceSyncInterval extends IntentService {

   public NotificationServiceSyncInterval() {
       super("Tracker");
   }

   public NotificationServiceSyncInterval(String paramString) {
       super(paramString);
   }

   @Override
   protected void onHandleIntent(Intent intent) {
       //ToDo: put what you want to do here
       Log.d("TAG", "Handler call");
   }
}