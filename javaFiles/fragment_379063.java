// This will define a node in which the preferences can be stored
prefs = Preferences.userRoot().node(this.getClass().getName());
// First we get the values
// Define a boolean value with the default true
prefs.getBoolean("Test1", true);
// Define a string with default "Hello World"
prefs.get("Test2", "Hello World");
// Define a integer with default 50
prefs.getInt("Test3", 50);
// now set the values
prefs.putBoolean("Test1", false);
prefs.put("Test2", "Hello Europa");
prefs.putInt("Test3", 45);
// Delete the preference settings for the first value
prefs.remove("Test1");