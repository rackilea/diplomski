//Create and initialize your EditText
EditText editText = findViewById(R.id.txtEmergencyHomePhone);

//Get the String that's contained in the EditText
String userInput = editText.getText().toString();

//Convert the String to an Integer
int emergencyHome = Integer.parseInt(userInput);