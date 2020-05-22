import java.util.Scanner;

public class TestEquation {

private static double solveFirstEquation(double n) {
    double y = 0;
    if (n > 0) {
        y = ((n - 1) + Math.pow(n, 2)) / n;
    }
    return y;
}

private static double solveSecondEquation(double n) {
    double y = 0;
    if (n > 1) {
        y = ((n - 2) + (Math.pow(n - 1, 2) + n - 3) + 1035) / (n - 1);
    }
    return y;

}
public static void main(String args[]) {
    System.out.println("How much is n?");
    double n = 0;
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextDouble();
    System.out.println(solveFirstEquation(n));
    System.out.println(solveSecondEquation(n));
}