private static void setDefaultUncaughtExceptionHandler() {
    try {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                logger.error("Uncaught Exception detected in thread {}", t, e);
            }
        });
    } catch (SecurityException e) {
        logger.error("Could not set the Default Uncaught Exception Handler", e);
    }
}