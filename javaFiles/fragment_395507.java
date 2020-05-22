public static String printTriangle(int n) {
    if (n <= 0) {
        return "";
    } else if (n == 1) {
        return printStars(1);
    }
    return printTriangle(n - 1) + System.lineSeparator() + printStars(n);
}