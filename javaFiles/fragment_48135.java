import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringMeasurer.class)
public class MyMockito {
    @Test
    public void testSuppressMethod() throws Exception {
        PowerMockito.mockStatic(StringMeasurer.class);
        when(StringMeasurer.measure(any(String.class))).thenReturn(10);
        System.out.println(StringMeasurer.measure("Hello"));
    }
}