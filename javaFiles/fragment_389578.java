private TextView mTvAcc;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // you only need to do this once since we are making the object a instance variable!
    mTvAcc = (TextView) findViewById(R.id.acc);

    // With this we load the data when the Activity is created 
    // This happens only once -- But with a large resource file you might want to 
    // do load the data in an AsyncTask (more advanced)
    loadDataFromResourceFile();
}