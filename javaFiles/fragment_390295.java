// Add container
addPreferencesFromResource(R.xml.pref_container);

// Add 'general' preferences, and a corresponding header.
PreferenceCategory fakeHeader = new PreferenceCategory(this);
fakeHeader.setTitle(R.string.pref_header_general);
getPreferenceScreen().addPreference(fakeHeader);
addPreferencesFromResource(R.xml.pref_general);

// Add 'backup' preferences, and a corresponding header.
fakeHeader = new PreferenceCategory(this);
fakeHeader.setTitle(R.string.pref_header_backup);
getPreferenceScreen().addPreference(fakeHeader);
addPreferencesFromResource(R.xml.pref_backup);