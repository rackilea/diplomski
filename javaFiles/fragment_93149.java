String pathToUpload = "/Lighthouse.jpg";
URL url = MYCLASSNAME.class.getResource(pathToUpload);
String filePath = url.getFile();
System.out.print(filePath);
File imgToUpload = new File(filePath);
String absolutePath = imgToUpload.getAbsolutePath();
System.out.print(absolutePath);
driver.findElement(By.xpath("//input[@id='FakeInputName2']")).sendKeys(absolutePath);
System.out.print(driver.getPageSource());