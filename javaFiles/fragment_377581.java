public class MyException extends Exception {

public static final String MYSeparator = "!@#!";
public MyException() {
    super();
}

public MyException(String message) {
    super(message);
}

public MyException(Throwable cause) {
    super(cause);
}

public MyException(String message, Throwable cause) {
    super(message, cause);
}

public MyException(String errorCode, String errorDescription,
        Throwable cause) {
    super(errorCode + MYSeparator + errorDescription, cause);
}

public MyException(String errorCode, String errorDescription) {
    super(errorCode + MYSeparator + errorDescription);
}