public static final String SETTINGS_PREFERENCE = "SETTINGS_PREFERENCE"
SharedPreference settingsPrefString

//your code
//saveSettings method
//SAVE WEIGHT SETTING BETWEEN LB/KG
settingsPrefString = getSharedPreferences(SETTINGS_PREFERENCE , Context.MODE_PRIVATE);
SharedPreferences.Editor editor = settingsPrefString.edit();