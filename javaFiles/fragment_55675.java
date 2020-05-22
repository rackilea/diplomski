public class JavaActivity extends AppCompatActivity {

    PrefManager prefManager;
    RadioButton radio_indo, radio_english;
    RadioGroup appLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        prefManager = new PrefManager(this);

        radio_indo = findViewById(R.id.radio_indo);
        radio_english = findViewById(R.id.radio_english);
        appLang = findViewById(R.id.appLang);

        if (prefManager.getLanguage().equals("en")) {
            radio_english.setChecked(true);
        } else {
            radio_english.setChecked(true);
        }

        appLang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId) {
                    case R.id.radio_indo:
                        prefManager.setLanguage("id");
                        // you need to restart or recreate your activity after locale change
                        break;
                    case R.id.radio_english:
                        prefManager.setLanguage("en");
                        // you need to restart or recreate your activity after locale change
                        break;
                }
            }
        });
    }

}