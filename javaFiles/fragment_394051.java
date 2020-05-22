public static long fact(int n) {
    long res = 1;
    for (int i = n; i > 1; i--) res *= i;
    return res;
}

public static double pow(double base, int pow) {
    double r = 1;
    for (int i = 0; i < pow; i++) r *= base;
    return r;
}

public static double rem(double val1, long val2) {
    return val1/val2;
}

public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService es = Executors.newFixedThreadPool(5);
    double base = 0.5;
    int n = 10;
    CompletableFuture<Double> f1 = CompletableFuture.supplyAsync(() -> pow(base, n), es);
    CompletableFuture<Long> f2 = CompletableFuture.supplyAsync(() -> fact(n), es);
    CompletableFuture<Double> f3 = f1.thenCombineAsync(f2, (v1,v2)->rem(v1,v2), es);
    double r1 = f3.get();
    System.out.println("r1="+r1);
    // compare with the result of synchronous execution:
    double r2 = rem(pow(base, n), fact(n));
    System.out.println("r2="+r2);
}