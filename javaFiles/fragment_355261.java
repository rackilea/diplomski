public static double computeAverage(Collection<? extends Number> col) {
    double sum = 0.;
    for (Number n : col) {
      sum += n.doubleValue();
    }
    return sum / n.size();
}