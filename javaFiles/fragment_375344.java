package sg.java.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyclassTest {
    @Test
    public void testMaximumActiveDutyCycle() {
        Myclass clazz = new Myclass();

        assertTrue(clazz.maximumActiveDutyCycle() == 0f);
    }
}