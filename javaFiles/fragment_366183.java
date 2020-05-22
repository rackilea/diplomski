public class Exercise01 {

public static final int UPPER_LIMIT = 5;

public static void main(String[] args) {
    System.out.print(fractionSum(UPPER_LIMIT));
}

public static double fractionSum(int n) {

    if (n<1) {
        throw new IllegalArgumentException("Out of range.");
    }

    double total = 1;

    for (int i = 2; i <= n; i++) {
        total += (1/(double)i);
    }

    return total;
}

}