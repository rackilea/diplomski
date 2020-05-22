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