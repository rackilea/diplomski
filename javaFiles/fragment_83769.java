IList<IWebElement> bars = MyWebDriver.Driver.FindElements(By.TagName("rect"));
foreach (var bar in bars)
{
    Thread.Sleep(500);
    try
    {
        bar.Click();
    }
    catch (Exception e)
    {
    }
}