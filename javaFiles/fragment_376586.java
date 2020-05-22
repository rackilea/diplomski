double[] coordinates;
for(int c = 0; c < coordinates.length; c++){
    double coord = coordinates[c];
    BigDecimal x = BigDecimal.valueOf((int)coord);
    BigDecimal y = BigDecimal.valueOf(coord);
    y = y.subtract(x);
    y = y.scaleByPowerOfTen(y.scale);
    pixBool[(int)x.longValue()][(int)y.longValue()] = true;
}