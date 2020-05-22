collectingAndThen(
        groupingBy(
                parentKeyMapper,
                toImmutableListMultimap(childKeyMapper, valueMapper)
        ),
        ImmutableMap::copyOf
);