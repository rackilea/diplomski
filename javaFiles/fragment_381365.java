import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 */
public class FileSubstitution {

    static {
        System.setProperty("JCalEnv", getUserAppDirectory());
        System.setProperty("log4j.configurationFile", "log4j-fileName.xml");
    }

    public static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        logger.info("Hello, World");
    }

    static String getUserAppDirectory() {
        String osName = System.getProperty("os.name");
        System.out.println("os = " + osName);
        if (osName.contains("Mac")) {
            return  "target/.JCal/logs/JCal-log.log";
        }
        else {
            return  "target/JCal/logs/JCal-log.log";
        }
    }
}