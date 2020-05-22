public void testUnit() {
    // define two points on a function from t -> %
    // the rate of change between these two points
    // should have unit %/t
    Measure<Double, Dimensionless> p0 = Measure.valueOf(50.0, NonSI.PERCENT);
    Measure<Double, Dimensionless> p1 = Measure.valueOf(20.0, NonSI.PERCENT);

    Measure<Double, Duration> timeDifference = Measure.valueOf(10.0, SI.SECOND);

    // JSR-275 has no Amount, so have to convert and do math ourselves
    // these doubles are percents
    double p0Raw = p0.doubleValue(NonSI.PERCENT);
    double p1Raw = p1.doubleValue(NonSI.PERCENT);

    // this duration is in seconds
    double timeDifferenceRaw = timeDifference.doubleValue(SI.SECOND);

    // this is the slope of the secant between the two points
    // so it should be the %/s we want
    double rateSecant = (p1Raw - p0Raw) / timeDifferenceRaw;

    // let's see what we get
    Measure<Double, ?> answer = Measure.valueOf(rateSecant,
                                                NonSI.PERCENT.divide(SI.SECOND));
    System.out.println(answer);
}