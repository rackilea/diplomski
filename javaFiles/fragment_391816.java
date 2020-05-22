int[] memo;

public int fib(int n) {
    memo = new int[n+1]; // all initialized to 0
    return fib2(n);
}

private int fib2(int n) {
    int f = 0;

    if (memo[n] != 0)
       return memo[n];

    if (n <= 2) {
        f = 1;
    } else {
        f = fib2(n-2) + fib2(n-1);
    }

    memo[n] = f;
    return f;
}