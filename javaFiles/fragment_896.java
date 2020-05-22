import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class StackoverflowTest {

  public static class Test {

    private A a;
    private B b;

    public Test(B b) {
      this.b = b;
    }
  }

  public static class A {}

  public static class B {

    private final Map<String, Integer> sampleMap = new HashMap<>();

    public Map<String, Integer> getSampleMap() {
      return Collections.unmodifiableMap(this.sampleMap);
    }
  }

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  private B b;

  @org.junit.Test
  public void testWithMock() {

    Map<String, Integer> expectedMap = new HashMap<>();
    expectedMap.put("a", 1);
    expectedMap.put("b", 2);
    expectedMap.put("c", 3);

    when(b.getSampleMap()).thenReturn(expectedMap);

    Test underTest = new Test(b);

    assertThat(underTest.b.getSampleMap(), is(expectedMap));
  }
}