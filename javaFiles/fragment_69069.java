class AutomationTest {
  public AutomationTest() {
    driver = new Driver();
  }
}


class MyTest extends AutomationTest {
  @Test
  public void doThis() {
    driver.findElement... // driver will not be null now.
  }
}