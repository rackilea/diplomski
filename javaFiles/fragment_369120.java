public class Combo<T> implements Iterable<List<T>> {

    private final List<T> set;

    public Combo(List<T> set) {
        this.set = set;
    }

    public Iterator<List<T>> iterator() {
        BitSet combo = new BitSet(set.size());
        return new Iterator<List<T>>() {
            public boolean hasNext() {
                return combo.cardinality() < set.size();
            }

            public List<T> next() {
                int i = 0;
                while (combo.get(i))
                    combo.clear(i++);
                combo.set(i);
                return combo.stream().mapToObj(set::get).collect(Collectors.toList());
            }
        };
    }
}