TextView textView ;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    textView = findViewById(R.id.textView);

    String str = getIntent().getStringExtra("text");

    textView.setText(str);
}