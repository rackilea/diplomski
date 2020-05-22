Properties properties = new Properties();
File file = new File(this.getClass().getResource("/dme.properties").toURI());
try (InputStream is = new FileInputStream(file)) {
    properties.load(is);
}
properties.setProperty("a", "b");
try (OutputStream os = new FileOutputStream(file)) {
    properties.store(os, null);
}