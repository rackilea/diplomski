Properties prop = new Properties();

    try (FileOutputStream os = new FileOutputStream("config.properties"))
    {
        //set the properties value
        prop.setProperty("database", "localhost");
        prop.setProperty("dbuser", "mkyong");
        prop.setProperty("dbpassword", "password");

        //save properties to project root folder
        prop.store(os, null);

    } catch (IOException ex) {
        ex.printStackTrace();
    }