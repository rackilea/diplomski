@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main2);

btnPhoneOne = (ImageButton) findViewById(R.id.btnPhone1);
btnPhoneTwo = (ImageButton) findViewById(R.id.btnPhone2);
btnPhoneThree = (ImageButton) findViewById(R.id.btnPhone3);

txtNum1 = (TextView) findViewById(R.id.txtNumber1);
txtNum2 = (TextView) findViewById(R.id.txtNumber2);
txtNum3 = (TextView) findViewById(R.id.txtNumber3);

String number1 = getIntent().getStringExtra("number1");
String number2 = getIntent().getStringExtra("number2");
String number3 = getIntent().getStringExtra("number3");

txtNum1.setText(number1);
txtNum2.setText(number2);
txtNum3.setText(number3);

btnPhoneOne.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + txtNum1.getText()));
        startActivity(callIntent);
    }
});

btnPhoneTwo.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + txtNum2.getText()));
        startActivity(callIntent);
    }
});

btnPhoneThree.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + txtNum3.getText()));
        startActivity(callIntent);
    }
});