protected static Logger logger = null;

  static {
      System.setProperty("java.util.logging.SimpleFormatter.format", FORMATTER_CONFIG);
      logger = Logger.getLogger("myProject.MyThirdClass");
      Handler h = null;
      try {
         h = new FileHandler("LogHere.txt");
      }
      catch (Exception ex) {
          System.out.println("Exception");
      }
      h.setFormatter(new SimpleFormatter());
      logger.addHandler(h);
      logger.setLevel(Constants.LOGGING_LEVEL);
  }