public static int countDigits(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("Input should be positive");
    }
    int result = 0;
    while ((n / 10) != 0) {
        result++;
        n /= 10;
    }
    return result + 1;
}