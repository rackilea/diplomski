Preference.OnPreferenceChangeListener changeListener = new Preference.OnPreferenceChangeListener() {
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        // Code goes here            
        return true;
    }
};

EditTextPreference pref = (EditTextPreference)findPreference(getString(R.string.pref1));
pref1.setOnPreferenceChangeListener(changeListener);

EditTextPreference pref2 = (EditTextPreference)findPreference(getString(R.string.pref2));
pref2.setOnPreferenceChangeListener(changeListener);