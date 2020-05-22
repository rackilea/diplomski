public static double getHornerFraction(long[] c, int xFinal, int i) {
    if (i == c.length) {
        return 0;
    }
    return (getHornerFraction(c, xFinal, i+1) + c[i])/xFinal;
}