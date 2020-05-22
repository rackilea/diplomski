public static void main(String[] args) {
    //This really should be set as a command argument but, it works.

    //No min and max of seven chars of level.
    //System.setProperty("java.util.logging.SimpleFormatter.format", "%4$.7s %n");

    //Min and max of seven chars of level (right justified).
    //System.setProperty("java.util.logging.SimpleFormatter.format", "%4$7.7s %n");

    //Min and max of seven chars of level (left justified).
    //System.setProperty("java.util.logging.SimpleFormatter.format", "%4$-7.7s %n");

    //No min with max of one chars of level.
    System.setProperty("java.util.logging.SimpleFormatter.format", "%4$.1s %n");

    LogRecord r = new LogRecord(Level.SEVERE, "Message");
    r.setLoggerName("logger");
    r.setSourceClassName("class");
    r.setSourceMethodName("method");
    System.out.println(new SimpleFormatter().format(r));
}