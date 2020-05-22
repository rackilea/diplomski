interface NativeExample extends Library {
    NativeExample ne = (NativeExample) Native.loadLibrary("foo", NativeExample.class);
    int decrypt(String value, byte[] output, IntByReference outputBufferSize);
}

public class Main {
    public static void main(String[] args) {
        byte[] buffer = new byte[4096];
        IntByReference bufferSize = new IntByReference(buffer.length);

        int bytesWritten = NativeExample.ne.decrypt("foo", buffer, bufferSize);
        if (bytesWritten == 0 && bufferSize.getValue() > buffer.length) {
            // buffer was too small for decrypted output
            buffer = new byte[bufferSize.getValue()];
            bytesWritten = NativeExample.ne.decrypt("foo", buffer, bufferSize);
        }

        String decrypted = new String(buffer, 0, bytesWritten);
        System.out.println(decrypted);
    }
}