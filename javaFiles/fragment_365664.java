private static void add(Map<NGram, Counter> countMap, NGram ng) {
    Counter counter = countMap.get(ng);
    if (counter == null)
        countMap.put(ng, new Counter(1));
    else
        counter.increment();
}
private static final class Counter {
    private int count;
    public Counter(int count) {
        this.count = count;
    }
    public void increment() {
        this.count++;
    }
    public int get() {
        return this.count;
    }
    @Override
    public String toString() {
        return Integer.toString(this.count);
    }
}