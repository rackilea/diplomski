import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class NoNewLineFileInputStreamTest {

    private final static String txt = "testnl.txt";

    @BeforeClass
    public static void genTestFile() throws IOException {
        OutputStream os = new FileOutputStream(txt);
        os.write((
                "Hello\n" +
                ",\r\n" +
                "World!\r" +
                "").getBytes());
        os.close();
    }

    @Test
    public void readInt() throws IOException {
        InputStream is = new NoNewLineFileInputStream(txt);
        int c = is.read();
        while(c != -1) {
            Assert.assertTrue(c != '\n' && c != '\r');
            c = is.read();
        }
        is.close();
    }

    @Test
    public void readBytes() throws IOException {
        InputStream is = new NoNewLineFileInputStream(txt);
        int l = is.available();
        if(l > 0) {
            byte[] content = new byte[l];
            int n = is.read(content);
            String expected = "Hello,World!";
            Assert.assertEquals(expected.getBytes().length, n);
            Assert.assertEquals(expected, new String(content, 0, n));
        }
        is.close();
    }

    @Test
    public void readBytesOffset() throws IOException {
        InputStream is = new NoNewLineFileInputStream(txt);
        int l = is.available();
        if(l > 0) {
            byte[] content = new byte[l*3];
            int n = is.read(content, 3, 5);
            String expected = "Hello";
            Assert.assertEquals(expected.getBytes().length, n);
            Assert.assertEquals(expected, new String(content, 3, n));
        }
        is.close();
    }
}