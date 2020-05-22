// save string in sharedPreferences 
SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
SharedPreferences.Editor editor = settings.edit();
editor.putString("some_key", value); // here value is the string you want to save
editor.commit();                    

// restore string in sharedPreferences (usually you have this onCreate method) 
SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
String string = settings.getString("some_key", "");