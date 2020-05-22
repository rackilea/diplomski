//init
preferencesManager = new SharedPreferencesManager(getApplicationContext());

//Store Value
preferencesManager.storeValue(SharedPreferencesManager.MY_KEY_ONE, "superValue");

//Get value
String myKeyValue = preferencesManager.getStringValue(SharedPreferencesManager.MY_KEY_ONE);

//Check if value exists
if(myKeyValue == null){
     //loadFromJSON
}

//Clear all values
preferencesManager.clearAllValues();