public static Matcher<Double[]> arrayCloseTo(double[] array, double error) {
    List<Matcher<? super Double>> matchers = new ArrayList<Matcher<? super Double>>();
    for (double d : array)
        matchers.add(closeTo(d, error));
    return arrayContaining(matchers);
}