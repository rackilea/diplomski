private boolean drawGraph = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
        intent = getIntent();

        My_Array = intent.getLongArrayExtra("foxstrot.p3.masiv");
        //...................