@AfterMethod
    public void tearDown(ITestResult result)
    {

        if(ITestResult.FAILURE==result.getStatus()) {
            CaptureScreenshots.capturescreen(driver,result.getName(),"FAILURE");
        }
        else {
            CaptureScreenshots.capturescreen(driver,result.getName(),"SUCCESS");
        }
    }