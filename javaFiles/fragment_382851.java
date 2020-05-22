public class MissingValueException extends Exception {
    private static final long serialVersionUID = 1L;

    public MissingValueException(final String message) {
        super(message);
    }

    public MissingValueException(final String message, final Exception root) {
        super(message, root);
    }
}