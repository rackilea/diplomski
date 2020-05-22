public class OOTests {
  @BeforeClass
  public static void smokes() throws Exception {
    Assume.assumeThat(OODetector.isOOOnClassPath(), is(true));
  }

  // tests
}