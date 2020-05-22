public class Test {
    public static void main(String[] args) {
        ImmutableObject o = IntStream.range(0, 10).collect(
                () -> new ImmutableObject[] { new ImmutableObject(0) },
                (h, i) -> h[0] = h[0].changeState(i),
                (h1, h2) -> { throw new UnsupportedOperationException("Parallel not supported"); }
        )[0];
        System.out.println(o); // prints: 45
    }
}

class ImmutableObject {
    private final int v;
    ImmutableObject(int v) { this.v = v; }
    ImmutableObject changeState(int i) { return new ImmutableObject(this.v + i); }
    @Override public String toString() { return Integer.toString(this.v); }
}