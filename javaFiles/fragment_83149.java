public void returnbtn(View view) {

// Initialize insert textView
EditText insertcountBtn = findViewById(R.id.insertPushup);

// Initialize counter textView
TextView givencountBtn = findViewById(R.id.showCount);

int insertcountInt = 0;
int givencountInt = 0;

// get added int stuff from the insert textField
if (!TextUtils.isEmpty(insertcountBtn.getText()) && TextUtils.isDigitsOnly(insertcountBtn.getText())) {
    insertcountInt = Integer.parseInt(insertcountBtn.getText().toString());
}

// get string stuff from counter textView
String givencountString = givencountBtn.getText().toString();
if (!TextUtils.isEmpty(givencountString) && TextUtils.isDigitsOnly(givencountString)) {
    givencountInt = Integer.parseInt(givencountString);
}

if (givencountInt <= 0 && insertcountInt <= 0){
    Total = 0;
}  else if (givencountInt > 0 && insertcountInt <= 0) {

    Total = givencountInt;
} else if (givencountInt <= 0 && insertcountInt > 0) {
    Total = insertcountInt;
} else if (givencountInt > 0 && insertcountInt > 0){
    // Add Counter textView and Insert textView to an Int Total
    Total = givencountInt + insertcountInt;
}

// Create an Intent to return to the mainActivity.
Intent beginPushup = new Intent(this, MainActivity.class);

// Pass the current number to the push-up Counter activity.
beginPushup.putExtra(TOTAL_DONE, Total);

// Start mainActivity.
startActivity(beginPushup);
}