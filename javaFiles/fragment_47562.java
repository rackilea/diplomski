private int numberOfIntervals;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_time);
    Log.d(TAG, "onCreate: Started");
    numberOfIntervals = getIntent().getIntExtra(INTERVAL_COUNT, 0);
    Toast.makeText(this, "" + numberOfIntervals, Toast.LENGTH_LONG).show();
    Log.d(TAG, "" + numberOfIntervals);
    initializeViews();
}