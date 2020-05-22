public class LoggerDecorator implements Logger {
    Logger logger;
    public LoggerDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String msg) {

        /** YOUR CODE HERE WHEN SUBCLASSING **/

        /**
         * delegate to the base logger passed into the constructor to
         * perform existing logging operations.
         */
        logger.log(msg);
    }
}