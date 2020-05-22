public class Test {
    public static void main(final String args[]) {
        short[] arr = { 256, 0, 0, 0, 256, 0, 0, 0 };
        for (byte b : F(arr)) {
            System.out.print(b);
        }
    }

    public static byte[] F(short[] arr) {
        java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocate(arr.length * 2);
        bb.asShortBuffer().put(arr);
        return bb.array(); // this returns the "raw" array, it's shared and not copied!
    }
}