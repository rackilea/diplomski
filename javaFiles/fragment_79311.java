// read from properties file
    Properties properties = new Properties();

    try {
        File file = new File("path here");
        properties.load(new FileInputStream(file));
    } catch (IOException e) {
        e.printStackTrace();
    }

    String location = (String) properties.get("key.to.location");

    // write to properties file
    properties.setProperty("key.new.location", "new location");
    properties.store(new FileOutputStream(file), "comment");