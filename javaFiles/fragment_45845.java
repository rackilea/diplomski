@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    a.setOnClickListener(mStartListener);
    b.setOnClickListener(mStopListener);
}