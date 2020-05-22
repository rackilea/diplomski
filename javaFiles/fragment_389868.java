public static void uploadSampleImage(StaticSeleniumDriver driver)
{
    driver.setFileDetector(new LocalFileDetector());
    File file = new File(System.getProperty("user.dir") + "/resources/images/" + SAMPLE_DOCUMENT_FILE_NAME);
    Utils.Log("file exists: " + file.exists());

    String imagePath = file.getAbsolutePath();
    WebElement input = driver.findElement(By.name("file"));
    input.sendKeys(imagePath);
}