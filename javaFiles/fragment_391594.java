EditText location_input;  //declare globally

    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gps);
    location_input = (EditText)findViewById(R.id.locationInputText); //initialize here
    }