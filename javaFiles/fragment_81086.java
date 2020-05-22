@ExtendWith(MockitoExtension.class)
public class MockitoExample {

  static abstract class TestClass {
    public abstract int booleanMethod(boolean arg);
  }

  @Mock
  TestClass testClass;

  @BeforeEach
  public void beforeEach() {
    lenient().when(testClass.booleanMethod(eq(true))).thenReturn(1);
    lenient().when(testClass.booleanMethod(eq(false))).thenReturn(2);
  }

  @Test
  public void test() {
    assertEquals(1,testClass.booleanMethod(true));
    assertEquals(2,testClass.booleanMethod(false));
  }
}