@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstName = (EditText)findViewById(R.id.firstName);
        mLastName = (EditText)findViewById(R.id.lastName);
        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        TextView tv = (TextView) findViewById(R.id.sample_text);
                    tv.setText(Calculate(mFirstName.getText().toString(),mLastName.getText().toString()));
                }
            });
    }

    public native String Calculate(String jFirstName, String jLastName);