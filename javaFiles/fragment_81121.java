import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCase1 {

    @BeforeClass 
    public static void setUpClass() {      
        System.out.println("TestCase1 setup");
    }

    @Test
    public void test1() {
        assertEquals(2 , 2);
    }
}