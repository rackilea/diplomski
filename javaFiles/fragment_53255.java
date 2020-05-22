if (...the config file exists...) {
    try (FileReader fromFile = new FileReader("config.properties")) {
        prop.load(fromFile);
    }
}

if (!commandlineProperties.isEmpty()) {
    // read, and overwrite, properties from the commandline...
    prop.load(new StringReader(commandlineProperties));
}