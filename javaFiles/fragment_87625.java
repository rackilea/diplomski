@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        //addressObject = new address(this);
        



    }
    public void buttonOnClick(View v ) {
        parcelObject = new parcel(this);
        Button button=(Button) v;
        TextView textView = (TextView) findViewById(R.id.shippingTotal);
        parcelObject.shipping();
        textView.setText("Your Shipping Total is: $ " + parcelObject.sCost);
    }