SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences();
Boolean hasAppUpdated = prefs.getBoolean("hasAppUpdated", false);


if(hasAppUpdated) {
    prefs.edit().putBoolean("hasAppUpdated", false).apply();
    mWebview.clearCache(true);
}