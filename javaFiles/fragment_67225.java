class YourClassTest {

  Sheet wbSheet;

  @BeforeTest public void readExcel(...) {
    wbSheet = wb.getSheet(sheetName);
  }

  @Test public void test() {
    //you can use wbSheet here
  }

}