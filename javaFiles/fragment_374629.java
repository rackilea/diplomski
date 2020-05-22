private static final BigDecimal SECONDS_PER_HOUR = 
    BigDecimal.valueOf(DateTimeConstants.SECONDS_PER_HOUR);
...
DateTime dt1 = ...;
DateTime dt2 = ...;
Duration duration = new Duration(dt1, dt2);
BigDecimal result = BigDecimal.valueOf(duration.toStandardSeconds().getSeconds())
                              .divide(SECONDS_PER_HOUR)
                              .setScale(2, RoundingMode.HALF_DOWN);