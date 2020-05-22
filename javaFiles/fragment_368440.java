public static <T, P, C, V> Collector<T, ?, ImmutableMap<P, ImmutableMultimap<C, V>>> toPartitionedImmutableMultimap(
        Function<? super T, ? extends P> parentKeyMapper,
        Function<? super T, ? extends C> childKeyMapper,
        Function<? super T, ? extends V> valueMapper) {

    return Collectors.collectingAndThen(
            Collectors.groupingBy(
                    parentKeyMapper,
                    SO29417692.<T,C,V>toImmutableListMultimap(childKeyMapper, valueMapper)
            ),
            ImmutableMap::<P,ImmutableMultimap<C,V>>copyOf
    );
}