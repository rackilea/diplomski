Properties properties = new Properties();
properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
String url = properties.getProperty("jdbc.url");
String driver = properties.getProperty("jdbc.driver");
String username = properties.getProperty("jdbc.username");
String password = properties.getProperty("jdbc.password");
// ...