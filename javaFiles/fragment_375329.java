public class AddPatientActivity extends AppCompatActivity implements View.OnClickListener{


private static final int DATE_DIALOG_ID = R.layout.birthdaypicker;
private EditText editTextName;
private EditText editTextBirth;
private EditText editTextAge;
private EditText editTextComp;
private SimpleDateFormat dateFormat;
private Calendar c = Calendar.getInstance();
private Calendar now = Calendar.getInstance();
private Button buttonCalc;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_patient);

    editTextName = (EditText) findViewById(R.id.editTextName);
    editTextAge = (EditText) findViewById(R.id.editTextAge);
    editTextBirth = (EditText) findViewById(R.id.editTextBirth);
    editTextComp = (EditText) findViewById(R.id.editTextComp);
    buttonCalc = (Button) findViewById(R.id.buttonCalc);
    buttonCalc.setOnClickListener(this);
    dateFormat = new SimpleDateFormat("dd/MM/yyyy");


}

@Override
public void onClick(View view) {
    //if calc button is pressed
    if (view.getId() == R.id.buttonCalc) {
        String date = editTextBirth.getText().toString();
        try {
            c.setTime(dateFormat.parse(date));
            int age = now.get(Calendar.YEAR) - c.get(Calendar.YEAR);
            if (now.get(Calendar.DAY_OF_YEAR) < c.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }
            String idade = Integer.toString(age);
            editTextAge.setText(idade);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}