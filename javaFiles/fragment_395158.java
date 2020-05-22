public static int sumDownBy3(int n) {
    if (n <= 0) {
        return 0;
    }

    return n + sumDownBy3(n - 3);
}