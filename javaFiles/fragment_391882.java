public class UnsuportedPlayException extends Exception {

    private static final long serialVersionUID = 1L;

    public UnsuportedPlayException() {
        super();
    }

    public UnsuportedPlayException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsuportedPlayException(String message) {
        super(message);
    }

    public UnsuportedPlayException(Throwable cause) {
        super(cause);
    }
}