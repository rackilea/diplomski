public void screenshot(String path_screenshot) throws IOException{
    File srcFile=driver.getScreenshotAs(OutputType.FILE);
    String filename=UUID.randomUUID().toString(); 
    File targetFile=new File(path_screenshot + filename +".jpg");
    FileUtils.copyFile(srcFile,targetFile);
}