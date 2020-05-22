public Boolean isEven ( BigDecimal decimal, int precision ) {
    double d = decimal.doubleValue ();
    int i = 0;
    while ( ++i <= precision )
        d *= 10;
    return ( (int) d & 1 ) == 0;
}