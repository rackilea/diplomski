class Averager<V extends Number> implements Function<Collection<V>, Double> {
    @Override
    public Double apply(Collection<V> values) {
        double sum = 0.0;
        for (V value : values) {
            sum += value.doubleValue();
        }
        return Double.valueOf(sum / values.size());
    }
}

class Medianer<V extends Number> implements Function<Collection<V>, Double> {
    @Override
    public Double apply(Collection<V> values) {
        List<V> sorted = new ArrayList<>(values);
        sorted.sort(Comparator.comparingDouble(Number::doubleValue));
        // TODO treat odd/even number of elements separately
        return Double.valueOf(sorted.get(sorted.size() / 2).doubleValue());
    }
}

@Test
public void usingFunction() throws InterruptedException, ExecutionException {
    Collection<Integer> values = ints();

    Collection<Function<Collection<Integer>, Double>> functions = new ArrayList<>();
    functions.add(new Averager<>());
    functions.add(new Medianer<>());

    List<Callable<Double>> callables = functions.stream().map(f -> (Callable<Double>) () -> f.apply(values)).collect(Collectors.toList());

    List<Double> res = concurrently(callables);
    System.out.println(res);
}