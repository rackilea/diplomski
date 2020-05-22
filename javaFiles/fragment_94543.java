public <T> ImmutableMultiset<T> sum(final List<Multiset<T>> multisets)
{
    final ImmutableMultiset.Builder<T> builder = ImmutableMultiset.builder();
    multisets.forEach(builder::addAll);
    return builder.build();
}