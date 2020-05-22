EditText hoursIn;   
EditText minIn;

Button start;
Button stop;

TextView textViewTime;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timer);
    hoursIn = (EditText) findViewById(R.id.hoursET);   
    minIn = (EditText) findViewById(R.id.minET);

    start = (Button) findViewById(R.id.startButton);
    stop = (Button) findViewById(R.id.stopButton);

    textViewTime = (TextView) findViewById(R.id.timeDisp);