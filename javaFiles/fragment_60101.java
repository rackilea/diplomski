int powerUtil(int base, int exp, int mod) {
    if(exp == 0) return 1;
    int ret = powerUtil(base, exp / 2, mod) % mod;
    ret = 1LL * ret * ret % mod;
    if(exp & 1) {
        ret = 1LL * ret * base % mod;
    }
    return ret;
}

double power(int base, int exp, int mod) {
    if(exp < 0) {
        if(base == 0) return DBL_MAX; // undefined
        return 1 / (double) powerUtil(base, -exp, mod);
    }
    return powerUtil(base, exp, mod);
}