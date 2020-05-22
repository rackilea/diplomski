@BeforeTest
public void beforeTest() {
  try{
    panelController = new PanelController();
  } catch (Exception e) {
    fail("Test failed because dependency could not be instantiated. Exception was:"+e.getMessage());
  }
}