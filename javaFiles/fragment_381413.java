// Retrieve the user preference node for the package com.mycompany
Preferences prefs = Preferences.userNodeForPackage(com.mycompany.MyClass.class);

// Preference key name
final String PREF_NAME = "name_of_preference";

// Set the value of the preference
String newValue = "a string";
prefs.put(PREF_NAME, newValue);

// Get the value of the preference;
// default value is returned if the preference does not exist
String defaultValue = "default string";
String propertyValue = prefs.get(PREF_NAME, defaultValue); // "a string"