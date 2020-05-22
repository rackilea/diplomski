List<WebElement> customers = driver.findElements(By.xpath("//div[@id='Customers']/table/tbody/tr"));
for (int i = 0; i < customers.size(); i++)
{
    if (customers.get(i).getText().equals("SQA"))
    {
        System.out.println(i);
        break;
    }
}