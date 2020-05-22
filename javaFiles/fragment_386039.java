@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Compact = (RadioButton) findViewById(R.id.radCompact);
    MidSize = (RadioButton) findViewById(R.id.radMidSize);
    Luxury = (RadioButton) findViewById(R.id.radLuxury);
    txtResult = (TextView) findViewById(R.id.txtResult);
}