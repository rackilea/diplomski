import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)  // important
@PrepareForTest(MachineImpl.class)  // important: do not use Thread.class here
public class MachineImplTest {

    private MachineImpl classUnderTest;

    @Before
    public void beforeEachTest() {
        classUnderTest = new MachineImpl();
    }

    @Test
    public void sleep_Pass() {
        classUnderTest.sleep(0);
        classUnderTest.sleep(-100);
        classUnderTest.sleep(+100);
    }

    @Test
    public void sleep_Pass2() {
        // We do not want to mock all methods, only specific methods, such as Thread.sleep().
        // Use spy() instead of mockStatic().
        PowerMockito.spy(Thread.class);

        // These two lines are tightly bound.
        PowerMockito.doThrow(new InterruptedException()).when(Thread.class);
        Thread.sleep(Mockito.anyLong());

        classUnderTest.sleep(0);
        classUnderTest.sleep(-100);
        classUnderTest.sleep(+100);
    }
}