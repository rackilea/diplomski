public class StartUpReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {

      if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
         ////// reset your alrarms here 
      }

  }
}