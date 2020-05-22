public class ServerStatusReceiver extends BroadcastReceiver {
   public void onReceive(final Context context, final Intent intent) {
     // analyze the intent and determine what happened
     // pseudo code
     if  (intent.getBooleanExtra("com.your.app.EXTRA_NETWORK_IS_UP", false) ) {
       serviceIsUp();
     } else {
       serviceIsDown();
     }
   }
}