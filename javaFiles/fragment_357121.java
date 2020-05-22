public class someClass extends Activity {
    public static String sharedPreferencesFileName = "myShared";
    public SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sharedPreferences = getSharedPreferences(sharedPreferencesFileName,0);
    }