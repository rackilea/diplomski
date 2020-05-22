public class ReadProperties {

    public static String getPropertyValue(String key) throws IOException {
        String filePath = "src/main/resources/data/config.properties";
        InputStream input = new FileInputStream(filePath);
        Properties prop = new Properties();

        try (input) {
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}