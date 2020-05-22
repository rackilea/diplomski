CheckBoxPreference checkBox = (CheckBoxPreference) findPreference("pushCheckBox");
checkBox.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object value) {
                //your code here
                return true;
            }
});