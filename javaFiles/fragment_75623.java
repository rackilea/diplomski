public class Settings { 

    Properties config = new Properties();
    InputStream input = null;

    public Settings(){
        input = getClass().getClassLoader().getResourceAsStream("config.properties");
        // or use input = new FileInputStream("config.properties");
        config.load(input)
    }

    .... // other of your functions
 }