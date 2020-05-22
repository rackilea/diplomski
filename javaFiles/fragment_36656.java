public class AppTest {

  @DataProvider
  public static Object[][] dp() {
    String input = System.getProperty("input");
    return new Object[][] {
      new Object[] { input }
    }
  }

  @Test(dataProvider="dp")
  public void print(String strInput) {
      System.out.println("String: " + strInput);
  }
}