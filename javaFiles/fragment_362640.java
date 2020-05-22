private void reduce() {
    boolean neg = (num < 0) != (den < 0);
    num = Math.abs(num);
    den = Math.abs(den);
    // obtain the GCD of the non-negative values.
    int g = Helper.gcd(num, den);

    num /= g;
    den /= g;
    if (neg) num *= -1;
}