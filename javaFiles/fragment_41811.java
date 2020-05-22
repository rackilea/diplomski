@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    CollapsingToolbarLayout collapsingToolbar =
            findViewById(R.id.collapsing_toolbar);
    collapsingToolbar.setTitleEnabled(true);
    collapsingToolbar.setTitle("Profile");
    assert getSupportActionBar() != null;
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);