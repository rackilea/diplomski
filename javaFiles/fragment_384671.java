@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    one = (Button) findViewById(R.id.button1);
    one.setOnClickListener(this);
    tv = (TextView) findViewById(R.id.tvd);     
}