public class NonDigitNumberException extends InputMismatchException {
    public NonDigitNumberException(String message){ // you can pass in your own message
        super(message);
    }

    public NonDigitNumberException(){ // or use the default message
        super("input is not a digit");
    }
}