public class HeadsetService extends Service{

private static final String TAG = "HeadsetService";
private HeadsetReceiver hReceiver;
private int lastHeadsetState;

@Override
public IBinder onBind(Intent arg0) {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void onCreate() {

    super.onCreate();       
    hReceiver = new HeadsetReceiver();

}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    // Register a new HeadsetReceiver       
    IntentFilter hfilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);    
    registerReceiver(hReceiver, hfilter);

return START_STICKY;}

 private class HeadsetReceiver extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {

    if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {

        // ignore the initial sticky broadcast when the service starts
        if (isInitialStickyBroadcast()) {
        } 

        else { 

        int state = intent.getIntExtra("state", -1);
        switch (state) {
        case 0:             
            Log.d(TAG, "headset unplugged");
            //set lastHeadsetState to 0 for later comparison
        lastHeadsetState = 0;               
            Log.d(TAG, "lastHeadsetState set to 0");

        break;
        case 1:                             
            Log.d(TAG, "headset plugged in!");
            lastHeadsetState = (lastHeadsetState + 1);
            Log.d(TAG, "lastHeadsetState incremented by 1");
            //check if lastHeadsetState is exactly 1...any greater value means multiple broadcasts were received.
            if (lastHeadsetState == 1) {
        //do whatever you're going to do when the headset is plugged in here                   

        Log.d(TAG, "Headset state has changed from unplugged to plugged");
            }
             else 
                 Log.d(TAG, "Multiple broadcasts received, ignoring duplicates");

        break; 
        default:
            Log.w("uh", "I have no idea what the headset state is");
            }   
          }
       }
     }
   }
 }