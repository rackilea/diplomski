protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TextView ferryTime = (TextView)findViewById(R.id.ferrytime);
    ferryTime.setText(convert());
}