@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.result_xm);
    Intent i = getIntent();
    String sum1 = i.getStringExtra("sum1");
    String sum2 = i.getStringExtra("sum2");
    // etc