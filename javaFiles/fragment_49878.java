Collection<Callable<Double>> callables = new ArrayList<>();
callables.add(() -> {
    double sum = 0.0;
    for (Integer value : values) {
        sum += value.doubleValue();
    }
    return Double.valueOf(sum / values.size());
});
callables.add(() -> {
    List<Integer> sorted = new ArrayList<>(values);
    sorted.sort(Comparator.comparingDouble(Number::doubleValue));
    // TODO treat odd/even number of elements separately
    return Double.valueOf(sorted.get(sorted.size() / 2).doubleValue());
});