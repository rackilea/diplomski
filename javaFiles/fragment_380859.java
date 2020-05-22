public class OOTests {
  @Test
  public void smokes() throws Exception {
    Assume.assumeThat(OODetector.isOOOnClassPath(), is(true));
    // rest of test
  }
}