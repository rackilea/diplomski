// in your shared package

public class SharedClass {
  private final LoggingClass logging;
  public SharedClass(LoggingClass logging) {
    this.logging = logging;
  }

  public void log(String msg) {
    logging.log(msg);
  }
}

public interface LoggingClass {
  public void log(String msg);
}

// in your client package

public class ClientLogging implements LoggingClass {
  public void log(String msg) { GWT.log(msg); }
}

// in your server package

public class ServerLogging implements LoggingClass {
  public void log(String msg) { ServerLogger.log(msg); }
}