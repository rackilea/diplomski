public class myReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.ACTION_SHUTDOWN")){
            //DO SOMETHING HERE
         }
        else
         {
                ...
         }
    }

}