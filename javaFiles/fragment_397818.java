private static readonly By TestSelector = By.XPath("Your xpath");

public void ClickUpdate()
{
    //Use same selector/field
    Driver.FindElement(TestSelector).Click();
}

public void ClickUpdate2()
{
    //Use same selector/field
    Driver.FindElement(TestSelector).Click();    
}