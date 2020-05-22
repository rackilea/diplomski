Properties   properties = new Properties();
properties .load(new FileInputStream(new File("c:\\credentials.properties")));

String user = properties.getProperty("username");
String pass = properties.getProperty("password");
//...