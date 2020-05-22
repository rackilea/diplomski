public class ErrorCollectorTest {

  @Rule
  public ErrorCollector collector = new ErrorCollector();

  @Test
  public void testErrorCollection() {
    org.hamcrest.Matcher<Boolean> matchesTrue = org.hamcrest.core.IsEqual.equalTo(true);

    collector.checkThat("FAILURE", "BLA".equals("OK"), matchesTrue);
    collector.checkThat("FAILURE", "BLABLA".equals("OK"), matchesTrue);
  }
}