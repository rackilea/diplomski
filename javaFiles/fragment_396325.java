public void takeScreenshot(String screenshotName) {
    if (driver instanceof TakesScreenshot) {
        File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempFile, new File("screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            // TODO handle exception
        }
    }
}