SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
  public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

    // update your variables here

    // update your view according to the variables here.

  }
};

sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
sharedPrefs.registerOnSharedPreferenceChangeListener(listener);