String[] users = {"Add/Update Network Security", "Create User"};
int size = users.length;
for (int i=0; i<size; i++)
{
    String value=users[i];
    System.out.println(value);

    WebDriverWait wait = new WebDriverWait(driver, 30);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox' and @value='" +value +"']"))).click();               
}