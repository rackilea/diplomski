import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Example.class)
public class ExampleTest {
    private Example testSubject;

    @Mock
    private Lift lift;

    @Test
    public void testDoStuff() throws Exception {
        testSubject.doStuff();
        verify(lift).call(5);
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.whenNew(Lift.class).withNoArguments().thenReturn(lift);
        testSubject = new Example();
    }
}