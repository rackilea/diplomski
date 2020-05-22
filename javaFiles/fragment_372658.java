private final int SPLASH_DISPLAY_TIME = 3000;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    final Handler handler = new Handler();

    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent mainIntent = new Intent(SplashActivity.this,
                    LoginActivity.class);
            SplashActivity.this.startActivity(mainIntent);
            SplashActivity.this.finish();
            handler.removeCallbacks(this);
        }
    }, SPLASH_DISPLAY_TIME);

}