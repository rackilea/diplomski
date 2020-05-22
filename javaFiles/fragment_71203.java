public class ByteIncrement
{
    private final byte[] bytes;
    private final int startIndex;
    public ByteIncrement(byte[] bytes, int startIndex) {
        this.bytes = bytes;
        this.startIndex = startIndex;
    }
    public boolean inc() {
        int i;
        for (i = bytes.length-1; i >= startIndex; i--) {
            bytes[i]++;
            if (bytes[i] != 0)
                break;
        }
        // we return false when all bytes are 0 again
        return (i >= startIndex || bytes[startIndex] != 0);
    }
    public byte[] getBytes() {
        return bytes;
    }

    public static void main(String[] args) {
        ByteIncrement bi = new ByteIncrement(new byte[]{(byte)0xa4, 0x56, 0x17, (byte)0x9f, 0x00, 0x00, 0x00, 0x00}, 2 ); // first two bytes are constant -> 2
        while (bi.inc()) {
            byte[] bytes = bi.getBytes();
            for (byte b: bytes) {
                System.out.printf("%02X ", b);
            }
            System.out.println();
        }
    }
}