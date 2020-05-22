@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Load the preferences from an XML resource
    addPreferencesFromResource(R.xml.settings_layout);
    setHasOptionsMenu(true);

    //if you are using default SharedPreferences
    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());

    onSharedPreferenceChanged(sharedPrefs, getString(R.string.key1));
    onSharedPreferenceChanged(sharedPrefs, getString(R.string.key2));

}