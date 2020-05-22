@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Create DataHelper object and insert some sample data
    DataHelper datahelper = new DataHelper(this);
    datahelper.insertBreed ("Beagle");
    datahelper.insertBreed ("Bulldog");
    datahelper.insertBreed ("Chow Chow");

    // Get sample data from the database and display them in the spinner
    Spinner spinnerBreeds= (Spinner) findViewById(R.id.spinnerBreeds);
    ArrayList<String> list = datahelper.getAllBreeds();
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.text, list);
    spinnerBreeds.setAdapter(adapter);

    //Init second spinner
    DataHelper2 datahelper2 = new DataHelper2(this);
    datahelper2.insertAge("1");
    datahelper2.insertAge ("2");
    datahelper2.insertAge("3");

    // Get sample data from the database and display them in the spinner
    Spinner spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
    ArrayList<String> list2 = datahelper2.getAllAge();
    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.text, list2);
    spinnerAge.setAdapter(adapter2);
}