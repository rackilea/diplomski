public class PropertyHandler {

    private final Logger logger = Logger.getLogger(PropertyHandler.class.getName());

    private static PropertyHandler instance = null;

    private Properties props = null;

    private PropertyHandler() {
        try {
            props = new Properties();
            InputStream  in = PropertyHandler.class.getResourceAsStream("config.properties");
            props.load(in);
            in.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error when loading DAO properties file\n***\n{0}", e.getMessage());
        }

    }

    public static synchronized PropertyHandler getInstance() {
        if (instance == null) {
            instance = new PropertyHandler();
        }
        return instance;
    }

    public String getValue(String propKey) {
        return this.props.getProperty(propKey);
    }

}