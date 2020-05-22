public class BadGuessException extends Exception {

    private static final String message = "Sorry, that was an invalid guess!";

    public BadGuessException() {
        super(message);
    }
}