// Create object of SharedPreferences.
 SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
 //now get Editor
 SharedPreferences.Editor editor = sharedPref.edit();
 //put your value
 editor.putString("userName", "stackoverlow");

 //commits your edits
 editor.commit();