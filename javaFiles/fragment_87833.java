FirefoxProfile profile = new FirefoxProfile();
profile.setPreference("browser.download.folderList", 2);
profile.setPreference("browser.download.dir", "C:\\Windows\\temp");
profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");
profile.setPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer

WebDriver driver = new FirefoxDriver(profile);
driver.get("http://www.exinfm.com/free_spreadsheets.html");
driver.findElement(By.linkText("Capital Budgeting Analysis")).click();