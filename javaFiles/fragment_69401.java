@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    MainText = (TextView) findViewById(R.id.main_text);

    MovieTask mt = new MovieTask();
    mt.execute();
}