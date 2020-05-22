/** Declare variables **/
string descriptionTextXPath = "//div[contains(@class, 'description')]/h3";

/** Find the element **/
IWebElement h3Element = driver.FindElement(By.XPath(descriptionTextXPath));

/** Grab the text **/
string descriptionText = h3Element.Text;