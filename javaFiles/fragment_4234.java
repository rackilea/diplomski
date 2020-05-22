public static float decode(byte val) {
    val = (byte) (val >> 3);
    val = (byte) (val & 0x1F);
    return (float) (val + 10) / 10.0f;
}
public static byte encode(float val) {
    val *= 10.0f;
    val -= 10;
    int tmp = (int)val;
    byte tmp2 = (byte) (tmp << 3);
    return tmp2;
}

public static void main(String[] args) {
    for (int i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
        float f =  decode((byte)i);
        System.out.printf("%s\t%s%n", f, decode(encode(f)));
    }
}