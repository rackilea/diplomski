List<Long> timeResults = ...

@AfterMethod
public void afterMethod(ITestResult result) {
  timeResults.add(result.getEndMillis() - result.getStartMillis()) 
}