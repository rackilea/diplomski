import static org.junit.Assert.*;
import org.junit.Test;

// This test class contains two test methods
public class SimpleTest {

    private int add(int a, int b) {
        return a + b;
    }

    @Test public void test1() throws Exception
    {
        System.out.println("@Test1");
        assertEquals(add(1, 1), 2);
    }

    @Test public void test2() throws Exception
    {
        System.out.println("@Test2");
        assertEquals(add(100, -30), 70);
    }
}