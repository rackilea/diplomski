public class Logger {
  public static Logger INSTANCE;
  static {
      INSTANCE = new Logger();
  }

  private Logger() {
    ...
  }
}