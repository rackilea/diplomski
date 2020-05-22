public interface Mask {
   byte v();
}

public class UniversalReg<T extends Mask> {
  public byte b;
  public byte set(T mask, boolean val) {
     if (val) b |= mask.v();
     else b &= ~mask.v();
  }
}

public enum RegTst implements Mask {
    b1_abc(0x01),
    b2_xyz(0x02),
    b3_klm(0x04);

    private final byte v;
    private RegTst(int val) {
        v = (byte)val;
    }

    @Override public byte v() { return v; }
}