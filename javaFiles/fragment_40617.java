public class MyException extends RuntimeException {
    private final Integer errorCode;

    public MyException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}