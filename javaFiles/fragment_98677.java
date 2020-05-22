String fileName = System.getProperty("fileName");

    Properties props = new Properties();
    try (Reader reader = new FileReader(fileName)) {
        props.load(reader);
    }