package cipher;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static cipher.Range.mod;

public class RangeTest {

    @Test
    public void testSize() {
        Assert.assertEquals(Range.inclusive('a', 'c').size, 3);
    }

    @Test
    public void testMod() throws Exception {
        assertEquals(mod(-2, 5), 3);
        assertEquals(mod(-1, 5), 4);
        assertEquals(mod(0, 5), 0);
        assertEquals(mod(1, 5), 1);
        assertEquals(mod(2, 5), 2);
        assertEquals(mod(3, 5), 3);
        assertEquals(mod(4, 5), 4);
        assertEquals(mod(5, 5), 0);
        assertEquals(mod(6, 5), 1);
    }

    @Test
    public void testShift() throws Exception {
        Range r = Range.inclusive('a', 'd');
        Assert.assertEquals(r.shift('a', -2), 'c');
        Assert.assertEquals(r.shift('a', -1), 'd');
        Assert.assertEquals(r.shift('a', 0), 'a');
        Assert.assertEquals(r.shift('a', 1), 'b');
        Assert.assertEquals(r.shift('a', 2), 'c');
        Assert.assertEquals(r.shift('a', 3), 'd');
        Assert.assertEquals(r.shift('a', 4), 'a');
        Assert.assertEquals(r.shift('a', 5), 'b');
    }
}