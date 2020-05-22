..
private TextView userText ;  // declare here(this is your UserText)

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userText = (TextView)findViewById(R.id.Nametext); //assign value here
    ..
}