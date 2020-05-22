import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ A.class })
public class ATest {

    @Test
    public void publicMethod_test_false() throws Exception {

        A spy = PowerMockito.spy(new A());
        spy.publicMethod(false);
        PowerMockito.verifyPrivate(spy).invoke("privateMethod");
        PowerMockito.verifyPrivate(spy).invoke("callParentPublicMethod", false);
    }

    @Test
    public void publicMethod_test_true() throws Exception {

        A spy = PowerMockito.spy(new A());
        spy.publicMethod(true);
        PowerMockito.verifyPrivate(spy).invoke("privateMethod");
        PowerMockito.verifyPrivate(spy).invoke("callParentPublicMethod", true);
    }
}