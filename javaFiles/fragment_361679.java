@Override
    protected void onCreate(Bundle savedInstanceState) {    

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mNewTV = (TextView)findViewById(R.id.NewTV);
        String newstr = "hello";
        mNewTV.setText(newstr);
    }