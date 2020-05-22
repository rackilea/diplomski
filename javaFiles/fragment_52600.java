@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState != null) {
        isActivityRecreated = savedInstanceState.getBoolean(KEY_IS_ACTIVITY_RECREATED);
        if (isActivityRecreated) {
            // This activity has been recreated.
            // Reset the flag
            isActivityRecreated = false;

            // Write your code when this activity recreated.
            int videoId = savedInstanceState.getInt(Constants.VIDEO_ID);
            int categoryId = savedInstanceState.getInt(Constants.CATEGORY_ID);
            ...   
        }
    }
}