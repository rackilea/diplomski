class MyActivity extends Activity {

    private static final int DISPLAY_DATA = 1;
    // this handler will receive a delayed message
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // Do task here
            if (msg.what == DISPLAY_DATA) displayData();
        }
 };

 @Override
 void onCreate(Bundle b) {
     //this will post a message to the mHandler, which mHandler will get
     //after 5 seconds
     mHandler.sendEmptyMessageDelayed(DISPLAY_DATA, 5000);
 }
}