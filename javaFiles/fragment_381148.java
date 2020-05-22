private SharedPreferences.OnSharedPreferenceChangeListener listener;


//Loads Shared preferences
prefs = PreferenceManager.getDefaultSharedPreferences(this);

//Setup a shared preference listener for hpwAddress and restart transport
listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
           if (key.equals(/*key for shared pref you're listening for*/) {
               //Do stuff; restart activity in your case
            }
        };

prefs.registerOnSharedPreferenceChangeListener(listener);