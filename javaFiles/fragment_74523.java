public class YourInfoObject {
    private final AtomicInteger count = new AtomicInteger();
    public int increment() {
        return this.count.incrementAndGet();
    }
    public int get() {
        return this.count.intValue();
    }
    public void set(int value) {
        this.count.set(value);
    }
}