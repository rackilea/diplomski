import ch.qos.logback.classic.LoggerContext;

public static void main(String[] args) {
    LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
    System.out.println(context.getProperty("abc"));
}