SharedPreferences.Editor sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this).edit();

  String USERNAME = "James"
  int AGE = 24;
  int HEIGHT = 180;
  int WEIGHT = 65;

  editor.putString("username", USERNAME);
  editor.putInt("age", AGE);
  editor.putInt("height", HEIGHT);
  editor.putInt("weight", WEIGHT);
  editor.commit();