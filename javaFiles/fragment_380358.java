Properties properties = new Properties();
    try (Reader reader =
                 new FileReader(
                         System.getProperty("app.conf")
                       //this contains path:"D://config.properties"
                 )) {
        properties.load(reader);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    for (String propertyName: properties.stringPropertyNames()) {
        System.setProperty(propertyName, properties.getProperty(propertyName));
    }