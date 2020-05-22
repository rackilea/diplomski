public static boolean perfect(int n){
    int sum = 1;
    for (int i = 2; i < (n / 2) + 1; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum == n;
}