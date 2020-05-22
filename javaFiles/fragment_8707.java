Properties properties = new Properties();
InputStream in = getClass().getClassLoader().getResourceAsStream("cors.properties");
properties.load(in);
in.close();

for (String name : properties.stringPropertyNames()) {
    addHeader(name, properties.getProperty(name));
}