public class CardComponent
{
    private WebDriver driver;
    private WebElement card;
    private By deleteCardLocator = By.xpath(".//p[@class='option-list-option'][.='Delete']");
    private By acceptDeleteButtonLocator = By.xpath("//button[.='Accept']");

    public CardComponent(WebDriver webDriver, String cardName)
    {
        driver = webDriver;
        card = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//card[contains(., '" + cardName + "')]")));
    }

    public void delete()
    {
        openMenu();
        card.findElement(deleteCardLocator).click();
        driver.findElement(acceptDeleteButtonLocator).click();
    }

    private void openMenu()
    {
        new Actions(driver).moveToElement(card).perform();
        card.findElement(By.id("dots")).click();
    }
}