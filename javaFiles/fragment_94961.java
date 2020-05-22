public static int gcd(int a, int b) {
    int q = b;
    b = a % b;
    a = q;
    return (a != b && a != 0 && b != 0) ? gcd(a, b) : a - b;
}