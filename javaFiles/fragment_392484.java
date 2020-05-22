protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        /* add language listener */
        Preference langPref = (Preference) findPreference("langLocale");
        this.setupListener( langPref );

}


protected void setupListener( Preference preference ) {

    preference.setOnPreferenceChangeListener( new OnPreferenceChangeListener() {

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {

            /* set master config */
            Locale locale2 = new Locale( newValue.toString() );
            Locale.setDefault(locale2);
            Configuration config2 = new Configuration();
            config2.locale = locale2;

            /* add preference screen */
            getBaseContext().getResources().updateConfiguration(config2, getBaseContext().getResources().getDisplayMetrics());

            /* remove existing preferences */
            PreferenceScreen prefScreen = getPreferenceScreen();
            prefScreen.removeAll();

            LusilKanjiDrawPreferences.this.addPreferencesFromResource(R.xml.preferences);
            setTitle(R.string.app_name_title);

            /* re-add listener */   
            Preference langPref = (Preference) findPreference("langLocale");
            LusilKanjiDrawPreferences.this.setupListener( langPref );

            return true;

        }
    });

}