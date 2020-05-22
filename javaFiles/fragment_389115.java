public class Log4j2 {

  static {
    ConfigurationFactory.setConfigurationFactory(new CustomConfigurationFactory()); // This must be called before any other calls to Log4j
  }

  private static Logger logger = LogManager.getLogger();

  public static void main(String[] args) {
    logger.info("hello");
  }
}