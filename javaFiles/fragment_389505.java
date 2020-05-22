Properties properties = new Properties();
properties.load(getClass().getResourceAsStream("/application.properties"));
if (properties.getProperty("server.address").equals("${serverAddress}")) {
  setUrl("http://localhost:8080/v1");
} else {
  setUrl(properties.getProperty("server.address"));
}