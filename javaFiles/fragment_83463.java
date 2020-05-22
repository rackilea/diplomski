public class StaticProvider {
  @DataProvider(name = "create")
  public static Object[][] createData() {
    return new Object[][] {
      new Object[] { 
         {"String", 1},
         {"Integer",2} }
    }
  }
}