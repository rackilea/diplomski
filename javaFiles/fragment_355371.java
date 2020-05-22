// basically, define a bit-mask
public enum State {
  A(0x00000001),

  B(0x00000002),

  C(0x00000004);

  private final int mask;
  public State(int mask) {
    this.mask = mask;
  }

  public int mask() { return mask; }

  public boolean isPartOf(int mask) {
    return (this.mask & mask) != 0;
  }
}