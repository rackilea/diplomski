/*--- Saving ---*/

SharedPreferences prefs = 
    getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
prefs.edit().putInt(KEY_NAME, VALUE).apply();


/*--- Retrieving ---*/

int oldValue = 
    getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        .getInt(KEY_NAME, 0);