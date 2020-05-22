Ini iniFile = new Ini(new FileInputStream(new File("/path/to/the/ini/file.ini")));
/*
 * Removes a key/value you pair from a section
 */
// Check to ensure the section exists
if (iniFile.containsKey("Section")) { 
    // Get the section, a section contains a Map<String,String> of all associated settings
    Section s = iniFile.get("Section");

    // Check for a given key<->value mapping
    if ( s.containsKey("somekey") ) { 
        // remove said key<->value mapping
        s.remove("somekey");
    }
}

/*
 * Removes an entire section
 */
if (iniFile.containsKey("Section")) { 
    // Gets the section and removes it from the file
    iniFile.remove(iniFile.get("Section"));
}

// Store our changes back out into the file
iniFile.store(new FileOutputStream(new File("/path/to/the/ini/file.ini")));