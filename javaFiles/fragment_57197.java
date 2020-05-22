public class MainActivity extends FragmentActivity {
    //the runnable listening to the network
    private UDPListener udpl;

    //for logging and convenience
    private static final String TAG = "BRRT";   

    //set up the fragment manager
    private ViewPager pager;
    private ScreenFragmenStatePagerAdapter fragmentManager;

    //we will parse the handler data into this map and store the values by int keys
    private SparseArray<String> sensorDataMap = new SparseArray<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remove the titlebar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //keep the screen on while we are running
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //set up the pager to move through the fragments
        pager = (ViewPager) findViewById(R.id.viewPager);
        fragmentManager = new ScreenFragmenStatePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(fragmentManager);
    }

    @Override
    public void onResume(){

        //start up the thread
        Log.v(TAG, "start thread");
        startUDPListener();
        Log.v(TAG, "past start thread");    

        super.onResume();
    }


    //start up the thread to listen to the network, pass in the handle to this thread for messages
    private void startUDPListener(){
        //spawn the listener thread, pass in the context and the handler object
        try{
            udpl = new UDPListener(this.getApplicationContext(), sensorDataMap);

            //TODO remove this debug flag
            //DEBUG
            udpl.setDebug(true);
            //DEBUG 

            //set up the threaded reading, event throwing
            Thread reader = new Thread(udpl);
            reader.start();

        } catch(Exception e){
            //TODO real logging
            Log.v(TAG, "caught after trying to start thread");
            Log.v(TAG, e.getMessage());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}