public class EyeGesture extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("gesture").equals("WINK")) {

             //Disable Camera Snapshot
            abortBroadcast();

            Log.e("WINKED ","");
        }else {
            Log.e("SOMETHING", "is detected " + intent.getStringExtra("gesture"));
        }
    }
}