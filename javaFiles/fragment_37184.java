EditText l;
 EditText w;
 TextView a;
 Button b;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); 
    l = (EditText) findViewById(R.id.length);
    w = (EditText) findViewById(R.id.width);
    a = (TextView) findViewById(R.id.lblarea);
    b = (Button) findViewById(R.id.calculate);