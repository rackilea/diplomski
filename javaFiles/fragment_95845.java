public static void main(String[] args) {
    List<Callable<Double>> list = IntStream.range(1, 99)
            .<Callable<Double>>mapToObj(value -> callableFactory(value))
            .collect(Collectors.toList());
}

public static Callable<Double> callableFactory(int value) {
    return new Callable<Double>() {
        @Override public Double call() { return calculateResult(value); }
    };
}

public static Double calculateResult(int value) {
    return Math.random();
}