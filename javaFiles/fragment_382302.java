@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gAnswers = getResources().getStringArray(R.array.answers);
        gRandom = new Random();

        gTextSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        //.....
   }