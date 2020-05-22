public static <T> Collector<T,?,List<T>> toImmutableList() {
    return Collector.of(
        ImmutableList::<T>builder,
        ImmutableList.Builder::add,
        (b1,b2) -> b1.addAll(b2.build()),
        ImmutableList.Builder::build);
}