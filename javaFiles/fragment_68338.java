// Represents a range of integers, {a, a+1, ..., b}, in which a < b.
class Range {
  private final Object lock = new Object();
  private int a;
  private int b;
  Range(final int a, final int b) { setAB(a, b); }
  final int[] getAB() { synchronized(lock) { return new int[]{a, b}; } }
  final void setAB(final int a, final int b) {
    if (!(a < b)) { throw new IllegalArgumentException("Invalid range"); }
    synchronized(lock) { this.a = a; this.b = b; }
  }
  @Override public String toString() {
    int[] ab = getAB();
    int a = ab[0];
    int b = ab[1];
    return a + " < " + b;
  }
}