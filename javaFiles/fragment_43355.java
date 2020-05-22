public class InvalidInputException extends IllegalArgumentException {

    private int errorIndex;

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, int index) { 
         super("Invalid Input at index: " + index + " " + message);
         errorIndex = index;
    }

    public int getErrorIndex() { return errorIndex; }
}