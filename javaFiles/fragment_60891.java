public class Main {
    private Scanner scanner;

    public Main(Scanner theScanner) {
        this.scanner = theScanner;
    }
    public static void main(final String[] args) {
        new Main(new Scanner(System.in)).process();
    }

    public void process() {
        final Integer dividend = new IntegerReader(scanner).fetchIntegerNumber("Input dividend: ");
        final Integer divisor = new IntegerReader(scanner).fetchIntegerNumber("Input divisor: ");
        System.out.println(dividend);
        System.out.println(divisor);
    }
}