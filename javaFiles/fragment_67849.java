List<Foo> mins = foos.stream().collect(Collector.of(
    Accumulator::new,
    Accumulator::accumulate,
    Accumulator::combine,
    Accumulator::getFoos
    )
);