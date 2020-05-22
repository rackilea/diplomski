import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    private static final Logger normalLog = Logger.getLogger("rootLogger");
    private static final Logger specialLogger = Logger.getLogger("specialLogger");

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        normalLog.info("Normal info");
        specialLogger.info("Special info -- won't be logged due to min logging level for specialLogger");
        specialLogger.error("Special error -- will be logged");
    }
}