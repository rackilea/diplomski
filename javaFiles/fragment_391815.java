ArrayList<Integer> memo = new ArrayList<Integer>();

public int fib(int n) {
    if (memo.size() == 0)
       memo.add(0); // element 0 is never accessed
    return fib2(n);
}

private int fib2(int n) {
    int f = 0;

    if (n < memo.size())
       return memo.get(n);

    if (n<=2) {
        f = 1;
    } else {
       f = fib2(n-2) + fib2(n-1);
    }

    memo.add(f); // elements inserted in order
    return f;
}