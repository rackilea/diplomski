public static double sin(double x, int n) {
    double result = x;
    double term = x;
    for (int i = 3, n2 = n * 2; i <= n2; i += 2) {
        term *= -x * x / ((i - 1) * i);
        result += term;
    }
    return result;
}

public static void main(String... args) {
/*
    for (int i = -20; i <= 20; i++) {
        double d = i / 10.0;
        System.out.println(Math.sin(d) + " vs " + sin(d, 14));
    }
*/
    double d = -1.5;
    double sin = Math.sin(d);
    System.out.println("Searching for sin(" + d + ") = " + sin);
    for (int n = 2; n <= 14; n++) {
        System.out.println(n + ": " + sin + " vs " + sin(d, n) + " err: " + (sin(d, n) - sin));
    }
}