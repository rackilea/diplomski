@Config(url="http://myurl.com")
public class MyTestClass extends AutomationTest {

  @Test
  public void testInput() {
    setText(By.id('myInput'), "my test");
    String b = getText(By.id('myInput'));
    assertTrue(b.matches('[a-zA-Z0-9]{4,}'));
  }
}