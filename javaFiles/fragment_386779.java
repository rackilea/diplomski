public class Config {

static Properties prop = new Properties();

static {
    // load a properties file
    try {
        InputStream input = Config.class.getClassLoader().getResourceAsStream("mule-app.properties");
        InputStream input = 
        prop.load(input);

        String type = prop.getProperty("mule.env"); //<-- here you get local or test

        input = getClass().getClassLoader().getResourceAsStream(type + ".properties"); // here you get the file 

        prop.load(input);

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
public static final String USERNAME = prop.getProperty("username");
public static final String PASSWORD = prop.getProperty("password");
}}