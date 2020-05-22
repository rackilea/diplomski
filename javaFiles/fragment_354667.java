import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

public class TestBuffer {

    private static final String testStr = "Stackoverflow is a great place to discuss tech stuff!";
    private static final boolean END_OF_INPUT = true;

    private ByteBuffer bytes = ByteBuffer.allocate(1000);

    public TestBuffer() {

        System.out.println("init   : " + bytes.toString());
    }

    public static void main(String a[]) {
        TestBuffer buf = new TestBuffer();
        buf.writeBuffer();
        buf.readBuffer();
    }

    // write testStr to buffer
    private void writeBuffer() {
        CharBuffer testBuffer = CharBuffer.wrap(testStr);
        CharsetEncoder utf8Encoder = StandardCharsets.UTF_8.newEncoder();
        CoderResult result = utf8Encoder.encode(testBuffer, bytes, END_OF_INPUT);
        if (result.isError()) {
            bytes.clear();
            throw new IllegalArgumentException("That didn't go right because " + result.toString());
        }
        if (result.isOverflow()) {
            bytes.clear();
            throw new IllegalArgumentException("Well, too little buffer space.");
        }
        System.out.println("written: " + bytes.toString());
        bytes.flip();
    }

    // read buffer data back to byte array and print
    private void readBuffer() {
        byte[] b = new byte[bytes.remaining()];
        bytes.get(b);
        System.out.println("data   : " + new String(b, StandardCharsets.UTF_8));
        System.out.println("read   : " + bytes.toString());
        bytes.clear();
    }
}