import java.util.Scanner;
public class DemoScanner {
    public static void main(String[] args) {
        double value1 = 5, value2 = 3, result;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the symbol (+-*/): ");
        String symbol = in.next().substring(0, 1);
        in.close();

        if (symbol.equals("+")) {
            result = value1 + value2;
            System.out.println("<h1>The sum is " + result + "</h1>");
        } else if (symbol.equals("-")) {
            result = value1 - value2;
            System.out.println("<h1>The sub is " + result + "</h1>");
        } else if (symbol.equals("*")) {
            result = value1 * value2;
            System.out.println("<h1>The multiplication is " + result + "</h1>");
        } else if (symbol.equals("/")) {
            result = value1 / value2;
            System.out.println("<h1>The division is " + result + "</h1>");
        }
    }
}