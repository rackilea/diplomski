public static double f(double d) {
    double r = d - Math.floor(d) + 1;
    for (;d>1; d-=1) {
        r *= d;
    }
    return r;
}