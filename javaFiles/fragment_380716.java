SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); 
String restoredText = prefs.getString("text", null);
if (restoredText != null) {
  String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
  int idName = prefs.getInt("idName", 0); //0 is the default value.
}