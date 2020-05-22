public PageObject WaitForURL(string url)
{
    Console.WriteLine("WaitForURL : " + url);
    WebDriverWait _waitForURL = new WebDriverWait(_driver, TimeSpan.FromMilliseconds(30000));
    _waitForURL.Until((d) =>
    {
        try
        {
            return d.Url == url;
        }
        catch (Exception)
        {
            return false;
        }
    });
    Console.WriteLine("URL changed to : " + _driver.Url);

    return this;
}