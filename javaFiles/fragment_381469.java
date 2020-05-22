@Nonnull
public <T> String concatenateAny(@Nonnull final Collection<T> items, @Nonnull final Function<? super T, ?> mapper)
{
    return items.stream()
            .map(mapper)
            .map(String::valueOf)
            .collect(joining(","));
}