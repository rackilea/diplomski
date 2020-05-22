SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Your_Activity.this);

Editor editor = sp.edit();
editor.putString("username", "<username goes here>");
editor.putInt("score", <the score goes here>);
editor.commit();   // Do not forget this to actually store the values