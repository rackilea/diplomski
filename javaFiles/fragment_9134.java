public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "nextage_quiz";
    private static final int PRIVATE_MODE = 0;

    SharedPreferences getPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPrefs = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        ImageView background= (ImageView) findViewById(R.id.background);
        if(getPrefs.getInt("id",0) != 0) 
           background.setBackgroundResource(getPrefs.getInt("id",0));

    }