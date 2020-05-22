@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    startCheck();
}


    private boolean startCheck() {
        new Thread(new Runnable() {

                        @Override
                        public void run() {
        runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                          findViewById(R.id.InternetConnection).setVisibility(View.VISIBLE);
                    }
                });

        while(!isNetworkAvailable()) {

        try {
                                    Thread.sleep(100L);// 100 ms sleep
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
        }
        runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (findViewById(R.id.InternetConnection).getVisibility() == View.VISIBLE)
                {
                    findViewById(R.id.InternetConnection).setVisibility(View.GONE);
                }
                AttemptLoggingIn();
                    }
                });

        }
                    }).start();
    }