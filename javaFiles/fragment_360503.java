import static java.lang.Math.*;

static int euclideanDiv(int x, int y) {
    int r = floorDiv(x, y);
    // if the divisor is negative and modulo not zero, round up
    if (y < 0 && r * y != x) {
        r++;
    }
    return r;
}

static int euclideanMod(int x, int y) {
    int r = x - euclideanDiv(x, y) * y;
    return r;
}