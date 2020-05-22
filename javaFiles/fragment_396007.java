public class PropertiesHelper {
    public static Properties loadFromFile(String file) throws IOException {
        Properties properties = new Properties();
        FileInputStream stream = new FileInputStream(file);
        try {
            properties.load(stream);
        } finally {
            stream.close();
        }
        return properties;
    }
}