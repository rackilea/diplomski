@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        public void run() {
            finish();
            Intent intent = new Intent(Splash.this, Menu.class);
            startActivity(intent);
        }
    }, 5000);
}