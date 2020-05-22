SharedPreferences myPreference=PreferenceManager.getDefaultSharedPreferences(this);

   if(myPreference.getBoolean("prefKeepScreenOn", false)) {

       getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
  }