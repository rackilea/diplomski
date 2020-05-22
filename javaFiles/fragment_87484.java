static <E> List<E> randomSelectN(Collection<? extends E> coll, int n) {
    assert n <= coll.size();
    return coll.stream()
        .filter(new Selector(coll.size(), n))
        .collect(toList());
}