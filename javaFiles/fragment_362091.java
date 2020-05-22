public static IWebElement WaitForElementToAppear(IWebDriver driver, int waitTime, By waitingElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(waitTime));
        var element = wait.Until(d =>
        {
            var elem = driver.FindElement(waitingElement);
            if (elem.Enabled)
                return elem;
            else return null;
        });
        return element;
    }