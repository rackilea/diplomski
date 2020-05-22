import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EventMonitorTest {

    //This will create a mock of IEventListener
    @Mock
    IEventListener eventListener;

    //This will inject the "eventListener" mock into your "EventMonitor" instance.
    @InjectMocks
    EventMonitor eventMonitor = new EventMonitor();

    @Before
    public void initMocks() {
        //This will initialize the annotated mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        eventMonitor.doStuff(param);
        //Here you can verify whether the methods "doStuff1" and "doStuff2" 
        //were executed while calling "eventMonitor.doStuff". 
        //With "times()" method, you can even verify how many times 
        //a particular method was invoked.
        verify(eventListener, times(1)).doStuff1();
        verify(eventListener, times(0)).doStuff2();
    }

}