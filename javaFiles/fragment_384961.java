@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // assign layout
    setContentView(R.layout.activity_display_text);
    // then you can use it
    TextView textview = (TextView)findViewById(R.id.textView1);
    textview.setText(EnterText.mynumber);
    ...
}