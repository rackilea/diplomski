Properties properties;
InputStream stream;
ClassLoader classLoader = com.my.package.MyCustomJavaClass.class.getClassLoader();

// first, look for application-override.conf in the classpath (upper environments)
stream = classLoader.getResourceAsStream("application-override.conf");

// if null, check for application.conf (local environment)
if (stream == null) {
    stream = classLoader.getResourceAsStream("application.conf");
}

properties = new Properties();
properties.load(stream);
stream.close();