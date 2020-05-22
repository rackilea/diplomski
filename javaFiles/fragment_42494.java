static <T, U> int frequency(Collection<T> coll, Function<? super T, ? extends U> mapper, U criteria) {
    Objects.requireNonNull(coll);
    Objects.requireNonNull(mapper);
    Objects.requireNonNull(criteria);
    int frequency = 0;
    for(T t : coll) {
        if(criteria.equals(mapper.apply(t))) {
            frequency++;
        }
    }
    return frequency;
}