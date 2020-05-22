public static final String TAG = MainActivity.class.getSimpleName();

private CurrentWeather mCurrentWeather;

private TextView mTimeLabel;

private TextView mTempLabel;

private TextView mHumidityValue;

private TextView mPrecipValue;

private TextView mSummaryLabel;

private ImageView mIconImageView;



@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTimeLabel = (TextView) findViewById(R.id.timeLabel);
    mTempLabel = (TextView) findViewById(R.id.tempLabel);
    mHumidityValue = (TextView) findViewById(R.id.humidityValue);
    mPrecipValue = (TextView) findViewById(R.id.precipValue);
    mSummaryLabel = (TextView) findViewById(R.id.summaryLabel);