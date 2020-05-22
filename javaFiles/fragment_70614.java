char[] password = new char[]{'p','a','s','s','w','o','r','d','1'};

List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/form/table/tbody/tr[6]/td/input"));

for (WebElement elem : elements)
{
    if (elem.isEnabled())
        elem.sendKeys(Character.toString(password[elements.indexOf(elem)]));
}