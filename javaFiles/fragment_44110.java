@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Thread timer = new Thread() {
        public void run() {
            try {
                // sleep(R.integer.SplashActivityTime);
                sleep(5000);
            } catch (InterruptedException iEx) {
                iEx.printStackTrace();
            } finally {
                Intent mainActivity = new Intent(MainActivity.this,
                        SecondActivity.class);

                startActivity(mainActivity);
                finish();
            }
        }
    };
    timer.start();
}