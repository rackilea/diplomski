@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    setContentView(R.layout.activity_main);
}