protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (android.os.Build.VERSION.SDK_INT > 9) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    textview = (TextView)findViewById(R.id.status);
    header = "GET /ally.php HTTP/1.0\nHost: easyvote.co.in\n\n";
    Handler handler = new Handler();
    Thread connect = new network("easyvote.co.in", 80, header, textview, handler);
    connect.start();
}