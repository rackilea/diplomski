String[] users = {"Add/Update Network Security", "Create User"};
int size = users.length;
for (int i=0; i<size; i++)
{
    String value=users[i];
    System.out.println(value);
    WebElement element=driver.findElement(By.xpath("//input[@type='checkbox' and @value='" +value +"']"));
               JavascriptExecutor js = (JavascriptExecutor) driver;
               js.executeScript("arguments[0].click();", element);                           
}