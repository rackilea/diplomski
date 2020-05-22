// Access the default SharedPreferences
SharedPreferences preferences = 
  PreferenceManager.getDefaultSharedPreferences(this);

...

SharedPreferences.Editor editor = preferences.edit();
// Save the checked state
editor.putBoolean("myBox1", true);
editor.commit();

...

// Get and set the checked state
boolean myBox1State = preferences.getBoolean("myBox1", false);
myBox1.setChecked(myBox1State);