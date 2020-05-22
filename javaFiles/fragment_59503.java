@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pay);
    TextView printPay = (TextView) findViewById(R.id.printPay);

    String amountDouble = String.valueOf(getIntent().getDoubleExtra("amountDouble", 0.0));
    String yearDouble = String.valueOf(getIntent().getDoubleExtra("yearDouble", 0.0);
    String interestDouble = String.valueOf(getIntent().getDoubleExtra("interestDouble", 0.0);

    String sum1 = amountDouble;
    printPay.setText(sum1);
}