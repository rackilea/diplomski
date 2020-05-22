private Boolean mRequestingLocationUpdates;

    DatabaseHelper databaseHelper;
*********************************************************
    SQLiteDatabase database; //add this line
*********************************************************
    private TextView statedisplay, gradedisplay, heat, drought, wildfires, inlandFlooding,coastalFlooding;

    /**
     * Functionality: Instantiates the DatabaseHelper class and other UI Components like textviews
     * PreConditions: DatabaseHelper and textviews must be declared
     * PostConditions: Textviews are assigned and DatabaseHelper initialized
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_card);
        ButterKnife.bind(this);

        databaseHelper = new DatabaseHelper(this);
*********************************************************
        database = databaseHelper.getWritableDatabase(); //add this line
*********************************************************
        statedisplay = (TextView) findViewById(R.id.statedisplay);
        gradedisplay = (TextView) findViewById(R.id.gradedisplay);
        heat = (TextView) findViewById(R.id.heat);
        drought = (TextView) findViewById(R.id.drought);
        wildfires = (TextView) findViewById(R.id.wildfires);
        inlandFlooding = (TextView) findViewById(R.id.inlandFlooding);
        coastalFlooding = (TextView) findViewById(R.id.coastalFlooding);
        // initialize the necessary libraries
        init();

        // restore the values from saved instance state
        restoreValuesFromBundle(savedInstanceState);
    }   //end onCreate method