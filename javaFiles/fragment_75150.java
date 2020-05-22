SharedPreferences sharedPref = getSharedPreferences("ch4an.ytheloader", MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putString("trueThumbnail", intent_Thumb);
// Or if you want to put a bool assuming that you have a
// variable called intent_Thumb_as_boolean as a boolean
editor.putBoolean("trueThumbnail", intent_Thumb_as_boolean);
editor.commit();