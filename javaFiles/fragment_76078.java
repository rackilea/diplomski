Button fartnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main); //layout inflated
        fartnow = (Button) findViewById(R.id.bFartNow); //now it's ok