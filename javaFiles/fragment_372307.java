public Iterable<CountEntry<T>> descendingCounts() {
    return countIndex.keySet().descendingSet().stream()
            .flatMap((count) -> countIndex.get(count).stream())
            .map((element) -> new CountEntry<>(element, count(element)))
            .collect(Collectors.toList());
}

public static class CountEntry<T> {
    private final T element;
    private final int count;

    public CountEntry(T element, int count) {
        this.element = element;
        this.count = count;
    }

    public T element() {
        return element;
    }

    public int count() {
        return count;
    }

    @Override
    public String toString() {
        return element + ": " + count;
    }
}