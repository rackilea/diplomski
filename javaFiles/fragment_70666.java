public class DisplayMessageActivity extends Activity {

    public static final String KEY_BUNDLE_SOME_VALUE = "some_value";
    public static final String KEY_BUNDLE_SOME_OTHER_VALUE = "some_other_value";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String string1 = "";
        String string2 = "";
        if (bundle != null) {
            if (bundle.containsKey(KEY_BUNDLE_SOME_VALUE) {
                string1 = bundle.getString(KEY_BUNDLE_SOME_VALUE);
            }
            if (bundle.containsKey(KEY_BUNDLE_SOME_OTHER_VALUE) {
                string2 = bundle.getString(KEY_BUNDLE_SOME_OTHER_VALUE);
            }
        }
        // ...
    }
    // ...
}