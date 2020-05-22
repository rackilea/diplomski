@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);
    uName = getIntent().getStringExtra("username");
    // reset session
    authidCoDe = 0;

    // invoke session
    fetchAccD(uName);
}