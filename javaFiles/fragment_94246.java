File propertiesFile = new File("D:/media/myProperties.properties");
Properties properties = new Properties() {
    @Override
    public synchronized Object put(Object key, Object value) {
        if (get(key) != null) {
            // or some other RuntimeException you like better...
            throw new IllegalArgumentException(key + " already present.");
        }
        return super.put(key, value);
    }
}
try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(propertiesFile))) {
  properties.load(bis);

} catch (IllegalArgumentException ex) {
  //
}