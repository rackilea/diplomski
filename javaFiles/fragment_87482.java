static <E> List<E> shuffleSelectN(Collection<? extends E> coll, int n) {
    assert n <= coll.size();
    List<E> list = new ArrayList<>(coll);
    Collections.shuffle(list);
    return list.subList(0, n);
}