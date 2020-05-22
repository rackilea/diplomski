public class Preferences extends PreferenceActivity {

    // Preference Keys
    public static final String KEY_PREF_PERIMER = "perimer";
    public static final String KEY_PREF_LEGUAGE = "leguage";

    // Shared preference
    SharedPreferences mSharedPreferences;

    EditTextPreference mPreferencePerimer;
    ListPreference mPreferenceLeguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        // Shared preference
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // Perimer
        mPreferencePerimer = (EditTextPreference) getPreferenceScreen().findPreference(KEY_PREF_PERIMER);
        // Leguage
        mPreferenceLeguage = (ListPreference) getPreferenceScreen().findPreference(KEY_PREF_LEGUAGE);

        // Get current values
        String peri = mSharedPreferences.getString(KEY_PREF_PERIMER, "1");
        String leng = mSharedPreferences.getString(KEY_PREF_LEGUAGE, "2");
        int lengIndex = Integer.parseInt(leng) - 1;

        // Set preference summary
        mPreferencePerimer.setSummary(peri);
        mPreferenceLeguage.setSummary(mPreferenceLeguage.getEntries()[lengIndex]);

        // Required to get the updated value and update summary when you input distance
        mPreferencePerimer.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object value) {
                String peri = value.toString();

                //Update premier summary
                mPreferencePerimer.setSummary(peri);

                return true;
            }
        });

        // Required to get the updated value and update summary when you change language from list
        mPreferenceLeguage.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object value) {

                String leng = value.toString();
                int lengIndex = Integer.parseInt(leng) - 1;

                // Update leguage summary
                mPreferenceLeguage.setSummary(mPreferenceLeguage.getEntries()[lengIndex]);
                return true;
            }
        });
    }
}