String background = "#fff" //whatever color you want to put here put in hex 
SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
SharedPreferences.Editor editor = pref.edit();
editor.putString("background",background );
editor.putString("font",   personaliseFontSpinner.getSelectedItem().toString().toUpperCase());
editor.commit();