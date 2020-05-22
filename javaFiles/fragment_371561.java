public class PropertiesExtractor {
private static Properties properties;
static {
    properties = new Properties();
    URL url = PropertiesExtractor.class.getClassLoader().getResource("application.properties");
    try{
        properties.load(new FileInputStream(url.getPath()));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static String getProperty(String key){
    return properties.getProperty(key);
}