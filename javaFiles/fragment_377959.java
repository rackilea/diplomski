public class BitSequences {

    public static void main(String[] args) {
        for (int i = 0; i <= 64; ++i) {
            System.out.println(i + " " + bitSequences(i));
        }
    }

    public static long bitSequences(int length) {
        return bitSequences(length, Bit.NONE, Bit.NONE);
    }

    public static long bitSequences(int length, Bit prePreBit, Bit preBit) {
        if (length <= 0) {
            return 1;
        } else if (preBit == Bit.ONE) {
            return bitSequences(length - 1, preBit, Bit.ZERO);
        } else if (prePreBit == Bit.ZERO && prePreBit == Bit.ZERO) {
            return bitSequences(length - 1, preBit, Bit.ONE);
        }
        return bitSequences(length - 1, preBit, Bit.ONE)
             + bitSequences(length - 1, preBit, Bit.ZERO);
    }

    enum Bit {
        ZERO,
        ONE,
        NONE
    }
}