SharedPreferences prefs = getSharedPreferences("a filename", Context.MODE_PRIVATE);
// writing
SharedPreferences.Editor editor = sharedPref.edit();
editor.putString("cookie", "value");
editor.commit();
// reading
String cookie = sharedPref.getString("cookie", "defaultValue");