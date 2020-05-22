public static void tryToChangeSystemLogContextLoggers() {
    try {
        Field systemContextField = LogManager.class.getDeclaredField("systemContext");
        systemContextField.setAccessible(true);
        Object systemContext = systemContextField.get(LogManager.getLogManager());
        Method demandLoggerMethod = systemContext.getClass().getDeclaredMethod("demandLogger", String.class, String.class);
        demandLoggerMethod.setAccessible(true);
        java.util.logging.Logger logger = (java.util.logging.Logger)demandLoggerMethod.invoke(systemContext, "java.awt", null);
        logger.setLevel(java.util.logging.Level.WARNING);
        logger.setUseParentHandlers(false);
        logger = (java.util.logging.Logger)demandLoggerMethod.invoke(systemContext, "sun.awt", null);
        logger.setLevel(java.util.logging.Level.WARNING);
        logger.setUseParentHandlers(false);
        logger = (java.util.logging.Logger)demandLoggerMethod.invoke(systemContext, "javax.swing", null);
        logger.setLevel(java.util.logging.Level.WARNING);
        logger.setUseParentHandlers(false);
    } catch (Exception e) {
        //Well, I tried
    }
}