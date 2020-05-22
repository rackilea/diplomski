public static int fibonacci1(int n) {
    recCounter++; // <<-- here
    if (n == 1 || n == 2) {
        return 1;
    } else {
        return fibonacci1(n-1) + fibonacci1(n-2);
    }
}