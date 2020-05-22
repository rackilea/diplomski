public static String getProperty(String property) {
  String value = "";

  try (InputStream is = DAOFactory.class.getResourceAsStream("dao.properties")) {
    Properties prop = new Properties();

    prop.load(is);
    value = prop.getProperty(property);
  } catch (Exception e) {
    e.printStackTrace();
  }

  return value;
}