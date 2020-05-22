import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(A.class)
public class ATest {
    @Test
    public void testableMethod_should_do_this() throws Exception {
        A a = spy(new A());

        doReturn(1).when(a, "getMode");

        assertTrue(a.testableMethod());
    }
}