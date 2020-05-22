public class BitSetShiftList {
  private BitSet bitset;

  public void BitSetShiftList(int size) {
    bitset = new BitSet(size * 2);
  }

  public void setShift(int day, Shift shift) {
    int ordinal = shift.ordinal();
    assert ordinal >= 0 && ordinal <= 3;

    bitset.set(day * 2, (ordinal & 0x1) != 0);
    bitset.set(day * 2 + 1, (ordinal & 0x2) != 0);
  }

  public Shift getShift(int day) {
    int ordinal = (bitset.get(day * 2) ? 0x1 : 0x0) |
      (bitset.get(day * 2 + 1) ? 0x2 : 0x0);
    return Shift.values()[ordinal];
  }

}