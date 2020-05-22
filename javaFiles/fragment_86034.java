public static double generateUniqueDouble(List<Double> previous) {
    double d = RANDOM.nextDouble();
    while (previous.contains(d)) {
        d = RANDOM.nextDouble();
    }
    PREVIOUS.add(d);
    return d;
}