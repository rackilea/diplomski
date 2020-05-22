@AfterMethod
public void tearDown(ITestResult result) throws IOException {
    String location = "C:/eStore/Projects/Screenshots/Catalog/";  //location for images
    String methodname = result.getName(); // fetching test method name
    try {
        File screenshots = ((TakesScreenshot) augmentedDriver)
                               .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(
            screenshots,
            new File(location + methodName + "_" + ".png");
    } catch (Exception e) {
          e.printStackTrace();
    } finally {
          driver.quit();
    }
}