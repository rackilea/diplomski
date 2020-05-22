import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.spy;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Factory.class)
public class Tests extends TestCase {

    public void testFactory() throws Exception {

        Factory factorySpy = spy(new Factory());
        String s = factorySpy.factorObject();
        doNothing().when(factorySpy, "checkString", anyString());
        verifyPrivate(factorySpy, times(1)).invoke("checkString", anyString()); 
    }
}