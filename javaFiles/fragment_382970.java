// path to your .properties file
Resource resource = new ClassPathResource("/my.properties");
Properties props = PropertiesLoaderUtils.loadProperties(resource);

....
String someValue = props.getProperty("someKey", "DEFAULT_VALUE");