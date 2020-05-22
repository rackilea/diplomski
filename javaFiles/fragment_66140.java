uintmax_t powmod(uintmax_t x, uintmax_t e, uintmax_t m) {
    uintmax_t result = 1;
    while (e > 0) {
        if (e&1) {
            result = result * x % m;
        }
        x = x * x % m;
        e >>= 1;
    }
    return result;
}