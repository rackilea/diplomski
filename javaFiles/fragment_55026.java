static public final class UncaughtAwtExceptionHandler {
    public static void installAsUncaughtAwtExceptionHandler() {
        System.setProperty("sun.awt.exception.handler", 
            UncaughtAwtExceptionHandler.class.getName() );
    }
    public UncaughtAwtExceptionHandler() {
        /* Nothing to construct */
    }
    public void handle(Throwable ex) {
        /* Do something here to transmit the exception 
           to your server, or log it, or whatever */
    }
}