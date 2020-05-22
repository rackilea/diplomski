SharedPreferences setting = getSharedPreferences(PREFS_NAME, 0);
if (setting.getString("log", "").toString().equals("log")) {
    // someView is just an example of a view's id. You will need to change that
    // to the id of the view you want to go into your save method.
    // The id is defined in your xml file. 
    View v = findViewById(R.id.someView);
    save(v);
}