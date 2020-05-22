import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestNonStaticMock {

    private final Integer staticMethodOutput = 10;

    @Mock
    NonStaticClass mock = new NonStaticClass();

    @InjectMocks
    Service service = new Service();

    @Before
    public void before () {
        setMock();
    }

    private void setMock() {
        when(mock.getLastUse()).thenReturn(staticMethodOutput);
    }

    @Test
    public void mockNonStaticMethod () {
        Integer result = service.getLastUse();
        System.out.println(result.toString());

        Assert.assertEquals(staticMethodOutput, result);
    }
}