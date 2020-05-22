private static final int SPLASH_TIME_OUT = 2000;
private static final Handler mHandler = new Handler();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    mHandler.postDelayed(new Runnable() {

        @Override
        public void run() {

                startActivity(new Intent(getApplicationContext(), YourActivity.class)); 
                finish();   
        }
    }, SPLASH_TIME_OUT);    
}