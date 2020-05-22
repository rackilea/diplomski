@DataProvider(name = "DP1")
public Object[][] createData() {
  Object[][] retObjArr={
  {"Link1","link_to_page"},
  {"Link2","link_to_page"},
  return retObjArr;
}

@Test (dataProvider = "DP1")
public void isActive(String name, String link){
  this.context.setAttribute("name", name);
  browser.click(link);
  Assert.assertTrue(browser.isLinkActive(link));
}