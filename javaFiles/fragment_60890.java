public class IntegerReader {

    private final Scanner scanner;

    public IntegerReader(Scanner theScanner) {
        this.scanner = theScanner;
    }

    public Integer fetchIntegerNumber(final String message) {
        System.out.print(message);
        final String inputString = scanner.nextLine();
        return Integer.valueOf(inputString);
    }
}