public class SomeTest {
  @Rule
  public ConditionalIgnoreRule rule = new ConditionalIgnoreRule();

  @Test
  @ConditionalIgnore( condition = NotRunningOnWindows.class )
  public void testFocus() {
    // ...
  }
}

public class NotRunningOnWindows implements IgnoreCondition {
  public boolean isSatisfied() {
    return !System.getProperty( "os.name" ).startsWith( "Windows" );
  }
}