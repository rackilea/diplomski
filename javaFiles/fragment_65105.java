public class SimpleByteSetter {

  /* b is is byte you are setting
     on is if the bit is set to on or 1
     place is the bit place in the range of 0-7
  */
  public static byte set(final byte b, final boolean on, final int place) {
    if (on) { return (byte) (b | ((1 << place) & 0xFF)); }
    return (byte) (b & (~((1 << place) & 0xFF)));
  }

  // 1 == on everything else off (but only use 0!)
  public static byte set(final byte b, final int on, final int place) {
    return set(b, 1==on, place);
  }

}