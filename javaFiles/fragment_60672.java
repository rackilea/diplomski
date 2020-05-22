public class MainActivity extends Activity{
    public static boolean activityStatusFlag= false; 
        //define this variable to check if activity is running or not.

     @Override
     protected void onResume() {
        super.onResume();   
        activityStatusFlag = true;
        this.getApplicationContext().
        registerReceiver(mMessageReceiver,new IntentFilter("mUpdateActivity"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityStatusFlag = false;  
        this.getApplicationContext().unregisterReceiver(mMessageReceiver);
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
                //Display Popup or update Activity
        }
    };
}