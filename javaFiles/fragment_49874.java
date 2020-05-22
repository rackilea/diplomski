class Averager<V extends Number> implements Callable<Double> {

    private final Collection<V> values = new ArrayList<>();

    Averager(Collection<V> values) {
        this.values.addAll(values);
    }

    @Override
    public Double call() {
        double sum = 0.0;
        for (V value : values) {
            sum += value.doubleValue();
        }
        return Double.valueOf(sum / values.size());
    }
}

class Medianer<V extends Number> implements Callable<Double> {

    private final Collection<V> values = new ArrayList<>();

    Medianer(Collection<V> values) {
        this.values.addAll(values);
    }

    @Override
    public Double call() {
        List<V> sorted = new ArrayList<>(values);
        sorted.sort(Comparator.comparingDouble(Number::doubleValue));
        // TODO treat odd/even number of elements separately
        return Double.valueOf(sorted.get(sorted.size() / 2).doubleValue());
    }
}