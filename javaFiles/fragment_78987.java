public String getProperty(String name) {
  // defaultProperties are loaded from a file on a file system:
  // defaultProperties.load(new FileInputStream(new File(filePath)));
  // or from a file in the classpath:
  // defaultProperties.load(ResourceLoader.class.getResourceAsStream(filePath));
  return System.getProperty(name, defaultProperties.get(name));
}