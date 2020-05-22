protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test6);
    Bundle bundle = getIntent().getExtras();
    String name = bundle.getString("name");
    String number = bundle.getString("number");
    TextView tv = (TextView)findViewById(R.id.textView2);
    tv.setText(name + " " + number);
}