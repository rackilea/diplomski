// Repeats n n times.
private static void repeat(int n) {
    for (int i = 0; i < n; i++) {
        System.out.print(n);
    }
}

private static void print(int n, int v) {
    if (n == v) {
        // Just once for the deepest level.
        repeat(n);
    } else {
        // Wrap the inner print ...
        repeat(n);
        // Recurse with the next higher value.
        print(n + 1, v);
        // ... end the wrap.
        repeat(n);
    }
}

public static void print(int n) {
    System.out.print(n+": ");
    print(1, n);
    System.out.println();
}

public void test(String[] args) {
    for (int i = 1; i <= 9 ; i++) {
        print(i);
    }
}