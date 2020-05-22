SharedPreferences.OnSharedPreferenceChangeListener prefListener = 
        new SharedPreferences.OnSharedPreferenceChangeListener() {
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
            String key) {
        ....
    }
};
rates_storage.registerOnSharedPreferenceChangeListener(prefListener);