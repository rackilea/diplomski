/* FORCE XML TO BE RELOADED */

/* remove existing preferences */
PreferenceScreen prefScreen = getPreferenceScreen();
prefScreen.removeAll();

/* add preference screen */
MyPrefClass.this.addPreferencesFromResource(R.xml.preferences);

/* re-add listener */               
Preference langPref = (Preference) findPreference("languageLocale");
MyPrefClass.this.setupListener( langPref );