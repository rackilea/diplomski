public static BigInteger fibRecurse(int n) {
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    BigInteger v = fibRecurse(n - 1).add(fibRecurse(n - 2));
    memo.put(n, v);
    return v;
}