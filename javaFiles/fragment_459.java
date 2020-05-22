SharedPreferences sp1 = getSharedPreferences(PREF_NAME, MODE_PRIVATE);//THIS IS WORKING
count1 = sp1.getInt("count1", 0);
SharedPreferences.Editor editor = sp1.edit();
editor.putInt("count1", resulFinalCache);
count2 = sp1.getInt("count2", 0);
editor.putInt("count2", coinsFinalCache);
editor.commit();