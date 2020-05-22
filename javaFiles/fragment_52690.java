import java.math.BigDecimal;
import java.util.Scanner;

public class LargestOfTwo {

    private Scanner scanner;
    private Number a;
    private Number b;

    public static void main(String args[]) throws Exception {
        LargestOfTwo app = new LargestOfTwo();
        app.start();
    }

    private void start() {
        readInputs();
        Number largest = compare(a, b);
        System.out.print("Largest of the numbers is: " + largest);
    }

    private void readInputs() {
        scanner = new Scanner(System.in);
        System.out.println("Enter two numbers, and I will show you which one is largest\n");
        a = readInput();
        b = readInput();
    }

    private Number readInput() {
        Double d = scanner.nextDouble();
        if (d == Math.floor(d)) {
            return d.intValue();
        } else {
            return d;
        }
    }

    private Number compare(Number x, Number y) {
        if (new BigDecimal(x.floatValue()).compareTo(new BigDecimal(y.floatValue())) > 0) {
            return x;
        } else {
            return y;
        }
    }
}