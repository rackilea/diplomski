import static java.lang.Math.*;

static int euclideanDiv(int x, int y) {
    int r = x / y;
    // if the divident is negative and modulo not zero, round down for positive divisor, otherwise round up
    if (x < 0 && r * y != x) {
        r -= signum(y);
    }
    return r;
}

static int euclideanMod(int x, int y) {
    int r = x - euclideanDiv(x, y) * y;
    return r;
}