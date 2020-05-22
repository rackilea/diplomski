import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class UtilTest {
    @Test
    public void testMethod() {
        Method method = Whitebox.getMethod(Util.class, "method");
        assertNotNull(method);
    }

    @Test
    public void testStaticMethod() {
        Method method = Whitebox.getMethod(Util.class, "staticMethod");
        assertNotNull(method);
    }
}