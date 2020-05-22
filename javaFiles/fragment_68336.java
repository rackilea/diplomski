public final class A {
    private final Object o;
    private A(final Object o) { if (o == null) throw new Error(); this.o = o; }
    public static A a() { return new A(new Object()); }
    public Object getO() { return o; }
}