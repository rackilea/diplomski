public class Example {
    public static void main(String[] args) throws Exception {
        WeakHashMap<Example, Integer> CACHE = new WeakHashMap<>();
        CACHE.put(new Example(), 2);
        if (CACHE.containsKey(new Example())) {
            System.gc();
            System.out.println("missing? " + CACHE.get(new Example()));
        }
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}