public class JavaActivity extends AppCompatActivity {

    PrefManager prefManager;
    RadioButton radio_indo, radio_english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        prefManager = new PrefManager(this);
        radio_indo = findViewById(R.id.radio_indo);
        radio_english = findViewById(R.id.radio_english);

        if (prefManager.getLanguage().equals("en")) {
            radio_english.setChecked(true);
        } else {
            radio_english.setChecked(true);
        }
    }

}