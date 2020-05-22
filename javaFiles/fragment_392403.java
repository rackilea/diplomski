public static int factorial(int n) {
    int result = 1;
    while (n >= 1) {
        result = result * (n);
        n--;
    }
    return result;
}