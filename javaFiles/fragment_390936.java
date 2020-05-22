public static void main (String[] args) throws java.lang.Exception {
    int n = 3000000;

    boolean[] isPrime = new boolean[n+1];
    for (int i = 2; i <= n; i++) {
        isPrime[i] = true;
    }

    for (int factor = 2; factor*factor <= n; factor++) {
        if (isPrime[factor]) {
            for (int j = factor; factor*j <= n; j++) {
                isPrime[factor*j] = false;
            }
        }
    }

    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) System.out.println(i);
    }
}