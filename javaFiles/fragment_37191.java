protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button myButton = new Button(this);
    myButton.setText("Add Me");

    RelativeLayout ll = (RelativeLayout)findViewById(R.id.main_layout);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    ll.addView(myButton, lp);
}