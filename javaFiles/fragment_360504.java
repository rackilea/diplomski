import static java.lang.Math.*;

static int euclideanMod(int x, int y) {
    int r = abs(x) % abs(y);
    // apply the sign of divident and make sure the remainder is positive number
    r *= signum(x);
    r = (r + abs(y)) % abs(y);
    return r;
}