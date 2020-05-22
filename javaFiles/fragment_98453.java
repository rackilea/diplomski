LocalFileDetector detector = new LocalFileDetector();
File localFile = detector.getLocalFile("/file/path/filename.jpg");
RemoteWebElement input = (RemoteWebElement) myDriver().findElement(By.id("fileUpload"));
input.setFileDetector(detector);
input.sendKeys(localFile.getAbsolutePath());
clickButton("Attach File");