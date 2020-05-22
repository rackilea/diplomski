driver.get("http://apps.gdgps.net/apps_file_upload.php");
System.out.println("test a");
List<WebElement> upload = driver.findElements(By.cssSelector("input[class*='upfile_ultimo']"));
if (upload.isEmpty())
{
    System.out.println("test a - failed");
    driver.findElement(By.cssSelector("input[id='upload_button']")).click();
    driver.findElement(By.cssSelector("input[class*='upfile_ultimo']")).click();
}
else
{
    System.out.println("test a - passed");
    upload.get(0).click();
}