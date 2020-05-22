public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    Spinner spinnerConversions;
    TextView conversionFrom, conversionTo, outputResult;
    EditText userInput;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversionFrom = findViewById(R.id.fromValue);
        conversionTo = findViewById(R.id.toValue);
        outputResult = findViewById(R.id.resultOutput);
        userInput = findViewById(R.id.numInput);

        spinnerConversions = findViewById(R.id.conversionSpinner);

        list.add("Miles to Kilometers");
        list.add("Kilometers to Miles");
        list.add("Inches to Centimeters");
        list.add("Centimeters to Inches");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerConversions.setAdapter(adapter);

        String conversionType = list.get(0);
        String[] units = conversionType.split("to");
        String conFrom = units[0].trim();
        String conTo = units[1].trim();

        conversionFrom.setText(conFrom);
        conversionTo.setText(conTo);

        spinnerConversions.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Double d = 0.0;
                try {
                    d = Double.parseDouble(userInput.getText().toString().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
        switch (position){
            case 0:
                outputResult.setText(d * 1.6093 + "");

                break;
            case 1:
                //Do something

                break;
            case 2:
                //Do something

                break;
            case 3:
                //Do something

                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){}

}