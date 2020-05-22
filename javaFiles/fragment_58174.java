public class splash_screen extends AppCompatActivity {
    TextView text1, text2, text3,display;
    // int time= 3600000*8;
    public  String data;
    private UsbService usbService;
    private EditText editText;
    private MyHandler mHandler;
    public StringBuilder stringBuilder = new StringBuilder();
    long  time = 60000;
    private long result ;
    private long result2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        mHandler = new MyHandler(splash_screen.this);

        int mUIFlag = View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        getWindow().getDecorView().setSystemUiVisibility(mUIFlag);

        text1 = (TextView) findViewById(R.id.tv_hour);
        text2 = (TextView) findViewById(R.id.tv_minute);
        text3 = (TextView) findViewById(R.id.tv_second);
    }


    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case UsbService.ACTION_USB_PERMISSION_GRANTED: // USB PERMISSION GRANTED
                    Toast.makeText(context, "USB Ready", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_PERMISSION_NOT_GRANTED: // USB PERMISSION NOT GRANTED
                    Toast.makeText(context, "USB Permission not granted", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_NO_USB: // NO USB CONNECTED
                    Toast.makeText(context, "No USB connected", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_DISCONNECTED: // USB DISCONNECTED
                    Toast.makeText(context, "USB disconnected", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_NOT_SUPPORTED: // USB NOT SUPPORTED
                    Toast.makeText(context, "USB device not supported", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private final ServiceConnection usbConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName arg0, IBinder arg1) {
            usbService = ((UsbService.UsbBinder) arg1).getService();
            usbService.setHandler(mHandler);
            usbService.sendATGetACC();


        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            usbService = null;
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        setFilters();  // Start listening notifications from UsbService
        startService(UsbService.class, usbConnection, null); // Start UsbService(if it was not started before) and Bind it
    }

    @Override
    public void onPause() {
        try {
            unregisterReceiver(mUsbReceiver);
            unbindService(usbConnection);
        } catch (IllegalArgumentException ex) {
        }
        super.onPause();

    }

    @Override
    public void onDestroy() {
        try{
            if(mUsbReceiver!=null)
                unregisterReceiver(mUsbReceiver);
        }catch(Exception e){}
        super.onDestroy();
    }

    private void startService(Class<?> service, ServiceConnection serviceConnection, Bundle extras) {

        Intent serviceIntent = new Intent(this, splash_screen.class);
        this.startService(serviceIntent);
        startService(serviceIntent);

        if (!UsbService.SERVICE_CONNECTED) {
            Intent startService = new Intent(this, splash_screen.class);
            if (extras != null && !extras.isEmpty()) {
                Set<String> keys = extras.keySet();
                for (String key : keys) {
                    String extra = extras.getString(key);
                    startService.putExtra(key, extra);
                }
            }
            startService(startService);
        }
        Intent bindingIntent = new Intent(this, service);
        bindService(bindingIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void setFilters() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbService.ACTION_USB_PERMISSION_GRANTED);
        filter.addAction(UsbService.ACTION_NO_USB);
        filter.addAction(UsbService.ACTION_USB_DISCONNECTED);
        filter.addAction(UsbService.ACTION_USB_NOT_SUPPORTED);
        filter.addAction(UsbService.ACTION_USB_PERMISSION_NOT_GRANTED);
        registerReceiver(mUsbReceiver, filter);
    }

    public class MyHandler extends Handler {

        private final WeakReference<splash_screen> mActivity;

        public MyHandler(splash_screen activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UsbService.MESSAGE_FROM_SERIAL_PORT:
                    String data = (String) msg.obj;
                    mActivity.get().time(data);
                    break;
            }


        }

    }

    public  void time(String data) {
        long sec = Integer.parseInt(data);
        result = TimeUnit.SECONDS.toMillis(sec);
        Log.d("REPLY", "Result value"+result);

        result2 = time - result;
        Log.d("REPLY", "Result2 value"+result2);
        Log.d("REPLY", "Time value"+time);


        if(result>=time) {

            //usbService.sendATGetSTOP();
            Intent mainIntent = new Intent(splash_screen.this,
                    MainActivity.class);
            splash_screen.this.startActivity(mainIntent);
            // Close SplashScreenActivity.
            splash_screen.this.finish();
        }
        else{
            if (result >= time) {

               // usbService.sendATGetSTOP();
                Intent mainIntent = new Intent(splash_screen.this,
                        MainActivity.class);
                splash_screen.this.startActivity(mainIntent);
                // Close SplashScreenActivity.
                splash_screen.this.finish();

            } else {
               // Log.d("REPLY", "result2 value " + result2);
                splashScreenUseAsyncTask();

            } }
        }




    private void splashScreenUseAsyncTask() {
        // Create a AsyncTask object.
        final RetrieveDateTask retrieveDateTask = new RetrieveDateTask();
        retrieveDateTask.execute("", "", "");
        // Get splash image view object.
        final ImageView splashImageView = (ImageView) findViewById(R.id.logo_id);

        //for 5 Hours
        CountDownTimer countDownTimer = new CountDownTimer(result2, 1000) {
            @SuppressLint("DefaultLocale")
            @Override
            public void onTick(long l) {

                long Hours = l / (60 * 60 * 1000) % 24;
                long Minutes = l / (60 * 1000) % 60;
                long Seconds = l / 1000 % 60;

                // tv_days.setText(String.format("%02d", Days));
                text1.setText(String.format("%02d", Hours));
                text2.setText(String.format("%02d", Minutes));
                text3.setText(String.format("%02d", Seconds));

                AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
                anim.setDuration(500);
                anim.setRepeatCount(anim.INFINITE);
                anim.setRepeatMode(Animation.REVERSE);
                splashImageView.startAnimation(anim);


            }

            @Override
            public void onFinish() {

                if (!retrieveDateTask.isAsyncTaskComplete()) {
                    this.start();
                }
            }
        };
        // Start the count down timer.
        countDownTimer.start();

    }
    // This is the async task class that get data from network.
    @SuppressLint("StaticFieldLeak")
    private class RetrieveDateTask extends AsyncTask<String, String, String> {

        // Indicate whether AsyncTask complete or not.
        private boolean asyncTaskComplete = false;

        public boolean isAsyncTaskComplete() {
            return asyncTaskComplete;
        }

        public void setAsyncTaskComplete(boolean asyncTaskComplete) {
            this.asyncTaskComplete = asyncTaskComplete;
        }

        // This method will be called before AsyncTask run.
        @Override
        protected void onPreExecute() {
            this.asyncTaskComplete = false;
        }

        // This method will be called when AsyncTask run.
        @Override
        protected String doInBackground(String... strings) {
            try {
                // Simulate a network operation which will last for 10 seconds.
                Thread currTread = Thread.currentThread();
                currTread.sleep(result2);

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                return null;
            }
        }

        // This method will be called after AsyncTask run.
        @Override
        protected void onPostExecute(String s) {
            //usbService.sendATGetSTOP();

            // Start SplashScreenMainActivity.
            Intent mainIntent = new Intent(splash_screen.this,
                    MainActivity.class);
            splash_screen.this.startActivity(mainIntent);
            // Close SplashScreenActivity.
            splash_screen.this.finish();
            this.asyncTaskComplete = true;
            usbService.sendATGetACC();

        }
    }


}