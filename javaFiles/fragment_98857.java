public class MyPreferenceActivity extends ActionBarPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // add this line
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        // etc etc
    }

    // etc etc
}