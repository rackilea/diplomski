@Override
public void onCreate(Bundle savedInstanceState) {
    // If the activity is a PreferenceActivity, don't make the request
    if (!(mActivity instanceof PreferenceActivity)) {
        mActivity.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
    }