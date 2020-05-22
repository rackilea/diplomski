public boolean set(int n, int d) {
    if (d > 0) {
       numerator = n;
       denominator = d;
       return true;
    } else
       return false;
}