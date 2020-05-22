public class MainActivity extends AppCompatActivity {

//Declare the ui component
private Spinner spinner;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //initialize the ui component
    spinner = (Spinner) findViewById(R.id.spinner);

    //create a collection holding your desired time with a note first, we will check that later
    // to find if the user selects a time

    ArrayList<String> timer = new ArrayList<>();
    timer.add("Select your time");
    timer.add("10");
    timer.add("20");
    timer.add("30");
    timer.add("40");

    //create a adpter for the spinner and set that to the spinner
    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timer);
    spinner.setAdapter(spinnerAdapter);


    // create a onItemSelectedListener to get the user input from spinner
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //get the selected text from spinner
            String spinnerText = spinner.getSelectedItem().toString();


            //if the value is not "Select your time" then send them to another activity with intent
            if (!spinnerText.contentEquals("Select your time")) {

                Intent intent = new Intent(MainActivity.this, CountDownActivity.class);
                intent.putExtra("time", spinnerText);
                startActivity(intent);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
}