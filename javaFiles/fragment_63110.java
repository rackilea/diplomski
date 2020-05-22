package cipher;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CipherTest {

    @Test
    public void testZeroKey() throws Exception {
        Cipher cipher = new Cipher(Range.inclusive('a', 'z'), 0);
        assertEquals(cipher.encrypt("abcxyz"), "abcxyz");
        assertEquals(cipher.decrypt("abcxyz"), "abcxyz");
    }

    @Test
    public void testOneKey() throws Exception {
        Cipher cipher = new Cipher(Range.inclusive('a', 'z'), 1);
        assertEquals(cipher.encrypt("abcxyz"), "bcdyza");
        assertEquals(cipher.decrypt("bcdyza"), "abcxyz");
    }

    @Test
    public void testSizePlusOneKey() throws Exception {
        Cipher cipher = new Cipher(Range.inclusive('a', 'z'), 27);
        assertEquals(cipher.encrypt("abcxyz"), "bcdyza");
        assertEquals(cipher.decrypt("bcdyza"), "abcxyz");
    }
}