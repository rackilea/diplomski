@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    // Save the user's current state
    savedInstanceState.putString("media_url", mMediaUrl.toString());

    // Always call the superclass so it can save the view hierarchy state
    super.onSaveInstanceState(savedInstanceState);
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
        mMediaUrl = Uri.parse(savedInstanceState.getString("media_url"));
    }
}