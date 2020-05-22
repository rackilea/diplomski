protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_logo);
            Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                   TextView textview4 = (TextView) findViewById(R.id.textView4);
        textview4.setText("alalaalalalalalal");
            }
        }, 6000);
}