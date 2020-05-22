@RunWith(PowerMockRunner.class)
@PrepareForTest(Runtime.class)
public class TestClass {

  @Mock private Runtime mockRuntime;

  @Test
  public void test() {
    PowerMockito.mockStatic(Runtime.class);

    when(Runtime.getRuntime()).thenReturn(mockRuntime);
    when(mockRuntime.exec()).thenReturn("whatever you want");

    // do the rest of your test
  }
}