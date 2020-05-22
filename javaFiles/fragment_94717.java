// write (assuming 'uname' is the string you want to save)
// NOTE: getSharedPreferences needs a valid context (so you can call this in onResume/onPause, or just MyActivity.this.getSharedPreferences()
SharedPreferences settings = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
SharedPreferences.Editor editor = settings.edit();
editor.putString("username", uname);

// read
SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
String username = settings.getString("username","");