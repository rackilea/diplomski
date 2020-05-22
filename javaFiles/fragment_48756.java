public static int gcd(int a, int b) {

    if (a == 0 && b > 0) {
        // returns when a becomes  0
        return b;
    } else if (b == 0 && a > 0) {
        //returns when b becomes 0
        return a;

    } else if (a > b) {
        return gcd(b, a % b);
    } else {
        return gcd(a, b % a);
    }
}