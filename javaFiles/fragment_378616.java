@Benchmark @BenchmarkMode(Mode.AverageTime)
public void collect(Blackhole blackhole) {
    Stream<Double> stream = Stream.iterate(0.0, e -> Math.random());
    List<Double> list = stream.limit(1000000).collect(Collectors.toList());
    blackhole.consume(list);
}

@Benchmark @BenchmarkMode(Mode.AverageTime)
public void forEach(Blackhole blackhole) {
    Stream<Double> stream1 = Stream.iterate(0.0, e -> Math.random());
    List<Double> list = new ArrayList<>();
    stream1.limit(1000000).forEach(e -> list.add(e));
    blackhole.consume(list);
}

@Benchmark @BenchmarkMode(Mode.AverageTime)
public void collectParallel(Blackhole blackhole) {
    Stream<Double> stream = Stream.iterate(0.0, e -> Math.random());
    List<Double> list = stream.parallel().limit(1000000).collect(Collectors.toList());
    blackhole.consume(list);
}

@Benchmark @BenchmarkMode(Mode.AverageTime)
public void forEachParallel(Blackhole blackhole) {
    Stream<Double> stream1 = Stream.iterate(0.0, e -> Math.random());
    List<Double> list = Collections.synchronizedList(new ArrayList<>());
    stream1.parallel().limit(1000000).forEach(e -> list.add(e));
    blackhole.consume(list);
}