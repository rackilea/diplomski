static <E> List<E> conventionalSelectN(Collection<? extends E> coll, int remain) {
    assert remain <= coll.size();
    int total = coll.size();
    List<E> result = new ArrayList<>(remain);
    Random random = new Random();

    for (E e : coll) {
        if (random.nextInt(total--) < remain) {
            remain--;
            result.add(e);
        }
    }            

    return result;
}