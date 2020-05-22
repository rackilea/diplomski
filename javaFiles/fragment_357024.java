import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(A.class)
public class MockA {
    @Test
    public void test_not_mocked() throws Throwable {
        assertThat(new A("random string").check(), equalTo("checked random string"));
    }
    @Test
    public void test_mocked() throws Throwable {
         A a = mock(A.class); 
         when(a.check()).thenReturn("test");
         PowerMockito.whenNew(A.class).withArguments(Mockito.anyString()).thenReturn(a);
         assertThat(new A("random string").check(), equalTo("test"));
    }
}