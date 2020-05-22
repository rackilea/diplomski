public class Properties {
    private static final String PROPERTIES_FILE = "MyDatabaseProperties.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(new FileInputStream("MyDatabaseProperties.properties"));
        } catch (IOException e) {
            // THROW YOUR EXCEPTION HERE.
        }
    }
}