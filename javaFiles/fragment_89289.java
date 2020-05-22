SharedPreferences sharedPref = getSharedPreferences("my_pref", Context.MODE_MULTI_PROCESS);

Editor editor = sharedPref.edit();
editor.putInt("KEY", VAL);
..
..
editor.commit();