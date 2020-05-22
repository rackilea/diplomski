Properties props = new Properties();

InputStream is =
getClass().getClassLoader().getResourceAsStream("messages.properties");

props.load(is);