import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ATest {

    @Test
    public void test() {
        A a = mock(A.class);
        when(a.someMethod()).thenCallRealMethod();
        List<String> listInA = new ArrayList<String>();
        ReflectionTestUtils.setField(a, "list", listInA);
        assertThat(a.someMethod(), is(listInA));
    }
}