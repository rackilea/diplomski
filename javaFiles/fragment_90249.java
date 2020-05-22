public long tailOddonacci(int n) {
    if (n <= 3) {
        return 1;
    }
    return tailOddonacciRecursion(1, 1, 1, n - 3);
}

private long tailOddonacciRecursion(int a, int b, int c, int count) {
    if(count <= 0) {
        return c;
    }
    return tailOddonacciRecursion(b, c, a + b + c, count - 1);
}

public static void main(String[] args) {
    System.out.println(new Test().tailOddonacci(5));
}