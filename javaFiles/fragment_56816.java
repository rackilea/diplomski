if(hasMonthPassed()) {

    // Your code here

    // Set the preference
    SharedPreferences.Editor editor = prefs.edit();
    editor.putLong("myPreferenceKey", System.currentTimeMillis());
    editor.apply()
}