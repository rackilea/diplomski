driver.get("chrome://settings/clearBrowserData");
driver.manage().window().maximize();
JavascriptExecutor js = (JavascriptExecutor) driver; 
WebElement clearData = (WebElement) js.executeScript("return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog').querySelector('#clearBrowsingDataConfirm')");
// now you can click on clear data button
clearData.click();