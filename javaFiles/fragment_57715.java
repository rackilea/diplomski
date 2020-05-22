public class MainActivity extends AppCompatActivity {

    String myBodyRecord = "My_Body_Record.txt";
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");


    Button button;

    EditText weightInput;
    EditText ketoneBloodInput;
    EditText ketoneUrineInput;
    EditText bloodPressureInput;
    EditText bloodSugarInput;

    String weight;
    String ketoneBlood;
    String ketoneUrine;
    String bloodPressure;
    String bloodSugar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File(getApplicationContext().getFilesDir(),myBodyRecord);


        //Setting where to get the data from, ie what fields
        weightInput = findViewById(R.id.weight);

        ....................
    }
}