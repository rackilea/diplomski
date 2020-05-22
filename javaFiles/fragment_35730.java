/******* Create SharedPreferences *******/

    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE); 
    Editor editor = pref.edit();


/**************** Storing data as KEY/VALUE pair *******************/


    editor.putString("lang_code", "en");  // Saving string

    // Save the changes in SharedPreferences
    editor.commit(); // commit changes