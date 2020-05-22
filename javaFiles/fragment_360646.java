@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnOne = (Button)findViewById(R.id.button1);
    btnTwo = (Button)findViewById(R.id.button2);
    btnThree = (Button)findViewById(R.id.button3);

    // set button texts from intent data here with getIntent()

    btnOne.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+btnOne.getText()));
            startActivity(callIntent);
        }
    });

    btnTwo.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+btnTwo.getText()));
            startActivity(callIntent);
        }
    });

    btnThree.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+btnThree.getText()));
            startActivity(callIntent);
        }
    });
}