SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
  String name = preferences.getString("key","");
  if(!name.equalsIgnoreCase(""))
  {
      /* Edit the value here of key as you might find it suitable*/
  }