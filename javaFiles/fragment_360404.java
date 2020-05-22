EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
    }

    //Called when Button clicked
    public void calculate(View view) {
        et1.setText("test"); //ERROR IN THIS LINE

    }