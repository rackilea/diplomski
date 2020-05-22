private void loadSavedPreferences() {
    SharedPreferences sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(this);
    editText1.setText(sharedPreferences.getString("storedName", "YourName"));
    editText2.setText(sharedPreferences.getString("storedName2", "YourName"));
    editText3.setText(sharedPreferences.getString("storedName3", "YourName"));
}