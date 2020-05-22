@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    TextView mTimeLabel = (TextView) findViewById(R.id.textView1);
    Button a = (Button) findViewById(R.id.button1);
    Button b = (Button) findViewById(R.id.button2);

    a.setOnClickListener(mStartListener);
    b.setOnClickListener(mStopListener);
}