public class YourClass extends BroadcastReceiver {
    @Override
    public void onReceive(Context c, Intent i) {
          if(i.getAction().equals("android.intent.action.ACTION_SHUTDOWN")){
                     //Fire your code here      
          }
    }};
}