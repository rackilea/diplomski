import java.util.logging.Logger;

public class LocaleLoggingTest {

  public static void main(String[] args) throws Exception {
    Logger logger = Logger.getLogger("name", "logmessages");
    logger.info("testmessage");
  }
}