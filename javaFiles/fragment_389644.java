// Compute the terms of fibonacci up to n
public static void operation(long n) {
    long a = 0;
    long b = 1;
    while (a <= n) {
        System.out.println(a);
        b = a+b;
        a = b-a;
    }
}