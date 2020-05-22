@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    goButton = (Button) findViewById(R.id.goButton);
    question = (TextView) findViewById(R.id.question);
    pagetimer = (TextView) findViewById(R.id.pagetimer);
    noIndiacator = (TextView) findViewById(R.id.noIndiacator);
    resulttext = (TextView) findViewById(R.id.noIndiacator);
    Button button1 = (Button) findViewById(R.id.button1);
    Button button2 = (Button) findViewById(R.id.button2);
    Button button3 = (Button) findViewById(R.id.button3);
    Button button4 = (Button) findViewById(R.id.button4);

    generateQuestion(button1, button2, button3, button4);

}