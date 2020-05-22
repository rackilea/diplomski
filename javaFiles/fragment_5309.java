public void selectReturningDate(String date)
{
    WebElement dte= driver.findElement(arrivalDate);
    det.click();
    dte.clear();
    dte.sendKeys(date);
}