package java.lang;

public class Exception extends Throwable {

public Exception() {
    super();
    String exception = "Exception";
    logWithStack(exception);

}

public Exception(String message) {
    super(message);
    logWithStack(message);
}

public Exception(String message, Throwable cause) {
    super(message, cause);
    logWithStack(message);
}

public Exception(Throwable cause) {
    super(cause);
    logWithStack(cause.getMessage());
}

protected Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    logWithStack(message);
}

private void logWithStack(String exception) {
    System.out.println(exception);
    for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
        System.out.println(ste);
    }
}