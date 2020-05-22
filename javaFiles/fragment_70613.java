char[] password = new char[]{'p','a','s','s','w','o','r','d','1'};

for (int i = 0; i < 9; i++)
{
    WebElement elem = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/form/table/tbody/tr[6]/td/input[" + (i + 1) + "]"));

    if (elem != null && elem.isEnabled())
        elem.sendKeys(Character.toString(password[i]));
}