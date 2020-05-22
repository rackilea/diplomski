public static void DoCloseActiveTabEntire()
    {
        // So there is a defect in EDGE whereby the behavior of the code containted in the hover on the tab executes without
        // error but the action underneath does not occur. So in Edge, callng the hover method of the TAB as seen in the else condition 
        // below does nto display the CLOSE button which needs to be clicked.
        // So for Edge, javascript is used to display the button directly.
        IWebElement close;

        if (BrowserWindow.Instance.Browser == BrowserWindow.Browsers.Edge)
        {
            close = BrowserWindow.Instance.Driver.FindElement(byClosePanelButton);
            string js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible'; arguments[0].style.display='inline';";
            IWebDriver driver = BrowserWindow.Instance.Driver;
            IWebElement element = close;
            ((IJavaScriptExecutor)driver).ExecuteScript(js, element);
        }
        else
        {
            Element tab = new Element(byTab);
            tab.Hover();
            close = new Button(byClosePanelButton).WebElement;
        }
        close.Click();
    }