SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE); String restoredText = prefs.getString("numTxt", null); 
TextView textView = (TextView) findViewById(R.id.textViewName); //your textField?
textView.setText(restoredText);    
//or with EditText 
//EditText editText = (EditText) findViewById(R.id.editTextName);
//editText.setText(restoredText);