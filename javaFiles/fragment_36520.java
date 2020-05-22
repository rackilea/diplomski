public class MissingInitialContextException extends RuntimeException {
    public MissingInitialContextException() {
    }

    public MissingInitialContextException(String message) {
        super(message);
    }

    public MissingInitialContextException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingInitialContextException(Throwable cause) {
        super(cause);
    }

    public MissingInitialContextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}