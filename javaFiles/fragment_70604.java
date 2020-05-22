public static int More ...compare(double d1, double d2) {
   if (d1 < d2)
        return -1;           // Neither val is NaN, thisVal is smaller
    if (d1 > d2)
        return 1;            // Neither val is NaN, thisVal is larger

    long thisBits = Double.doubleToLongBits(d1);
    long anotherBits = Double.doubleToLongBits(d2);

    return (thisBits == anotherBits ?  0 : // Values are equal
            (thisBits < anotherBits ? -1 : // (-0.0, 0.0) or (!NaN, NaN)
             1));                          // (0.0, -0.0) or (NaN, !NaN)
}