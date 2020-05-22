protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FacebookSdk.sdkInitialize(getApplicationContext());
    setContentView(R.layout.activity_log_in);
    AppEventsLogger.activateApp(this);
    System.out.println("here");
}