.collect(Collector.of(
    ImmutableSortedMultiset::<String>naturalOrder,
    ImmutableSortedMultiset.Builder::add,
    (b1, b2) -> {b1.addAll(b2.build()); return b1;},
    ImmutableSortedMultiset.Builder::build)
);