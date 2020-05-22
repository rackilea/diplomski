@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
    // set layout ^^^^
    mEditText = (EditText) findViewById(R.id.SearchTB);
    new MyAsyncTask().execute();
}