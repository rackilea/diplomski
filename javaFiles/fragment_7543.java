for (WebElement div : lineItemDivs)
{
    if (div.findElements(By.cssSelector("[title='Wind']")).size() > 0)
    {
        div.findElement(By.tagName("input")).sendKeys("20000");
    }
}