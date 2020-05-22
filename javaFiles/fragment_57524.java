public class MappedList<S, T> extends AbstractList<T> {
    private final List<S> source;
    private final Function<S, T> fromTransformer;
    private final Function<T, S> toTransformer;

    public MappedList(List<S> source, Function<S, T> fromTransformer, Function<T, S> toTransformer) {
        this.source = source;
        this.fromTransformer = fromTransformer;
        this.toTransformer = toTransformer;
    }

    public T get(int index) {
        return fromTransformer.apply(source.get(index));
    }

    public T set(int index, T element) {
        return fromTransformer.apply(source.set(index, toTransformer.apply(element)));
    }

    public int size() {
        return source.size();
    }

    public void add(int index, T element) {
        source.add(index, toTransformer.apply(element));
    }

    public T remove(int index) {
        return fromTransformer.apply(source.remove(index));
    }

}

private void test() {
    List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));
    List<String> stringList = new MappedList<>(intList, String::valueOf, Integer::valueOf);
    intList.add(4);
    stringList.remove(0);
    System.out.println(intList); // Prints [2, 3, 4]
    System.out.println(stringList); // Prints [2, 3, 4]
}