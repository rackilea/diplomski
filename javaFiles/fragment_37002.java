public static synchronized void setDebugOn(boolean debugOn) {
    if (isAllDebugOn() ^ debugOn) {
        setAllDebugOn(debugOn);
        Enumeration en = LogManager.getCurrentLoggers();
        while (en.hasMoreElements()) {
            setDebugOn((Logger) en.nextElement(), debugOn);
        }
        setDebugOn(LogManager.getRootLogger(), debugOn);
    }
}

public static void setDebugOn(String name, boolean debugOn) {
    setDebugOn(getLogger(name), debugOn);
}

private static void setDebugOn(Logger logger, boolean debugOn) {
    logger.setLevel(debugOn ? Level.DEBUG : Level.INFO);
}