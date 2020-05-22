class MyResults {
    public final short a;
    public final int   b;
    public MyResults(short a, int b) { this.a = a; this.b = b; }
}


MyResults myMethod() {
    ...
    return new MyResults(42, 666);
}