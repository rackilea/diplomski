private static final class Pair<K, V> {
    private final K key;
    private final V value;

    private Pair(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "P: " + key + ", " + value;
    }
}

public static void main(final String[] args) {
    final Stack<Pair<String, Integer>> stack = new Stack<>();
    stack.add(new Pair<String, Integer>("Chair", 2));
    stack.add(new Pair<String, Integer>("Table", 2));
    stack.add(new Pair<String, Integer>("Bed", 44));
    Collections.sort(stack, new Comparator<Pair<String, Integer>>() {
        @Override
        public int compare(final Pair<String, Integer> o1, final Pair<String, Integer> o2) {
            return o2.value.compareTo(o1.value);
        }
    });
    System.out.println(stack);
}