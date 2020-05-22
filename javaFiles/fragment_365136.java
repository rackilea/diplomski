Properties preferences = new Properties();
preferences.put("color", "red");
preferences.put("style", "bold");
preferences.store(new FileOutputStream("prefs.properties"), "preferences");

// reload the properties
Properties preferences = new Properties();
preferences.load(new FileInputStream("prefs.properties"));