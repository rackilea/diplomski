public class MyListener extends TestListenerAdapter{
  @Override
  public void onTestSuccess(ITestResult tr){
    log("+",tr);
  }
  //and similar

  private void log(String string, ITestResult tr){
    List<ITestContext> k = this.getTestContexts();
    String testName = tr.getTestClass().getName();      
    for (ITestContext i: k)
    {
      if (i.getAttribute("name") != null)
        logger.info(testName+"."+i.getAttribute("name"));
    }
  }

}