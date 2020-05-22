public final CollectionMapper<T> filter(Filter<T> filter) {
    Collection<T> result = new ArrayList<>();
    Iterator<T> iterator = orginal.iterator();
    while (iterator.hasNext()) {
        T t = iterator.next();

        if (filter.match(t)) {
            result.add(t);
        }

    }

    return new CollectionMapper<>(result);
}