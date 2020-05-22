public class SettingsActivity extends AppCompatActivity {

private static final String PREF_NAME = "nextage_quiz";
private static final int PRIVATE_MODE = 0;

SharedPreferences getPrefs;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);

    getPrefs = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    final RelativeLayout Settingscreen = (RelativeLayout) findViewById(R.id.settingscreen);

    ImageView ImageViewBackground1 = (ImageView) findViewById(R.id.imageViewBackground1);
    ImageView ImageViewBackground2 = (ImageView) findViewById(R.id.imageViewBackground2);

    ImageViewBackground1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            Settingscreen.setBackgroundResource(R.drawable.faqicon);
            getPrefs.edit().putInt("id", R.drawable.faqicon).apply();
        }
    });

    ImageViewBackground2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            Settingscreen.setBackgroundResource(R.drawable.rateicon);
            getPrefs.edit().putInt("id", R.drawable.faqicon).apply();
        }
    });
}