FirefoxProfile profile = new FirefoxProfile(); 

profile.setPreference("browser.download.folderList", 2);

profile.setPreference("browser.download.manager.showWhenStarting", false);

profile.setPreference("browser.download.dir", **enter your download path**);

profile.setPreference("browser.helperApps.neverAsk.openFile",
            "text/csv, application/pdf, application/x-msexcel,application/excel,application/x-excel,application/excel,application/x-excel,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/excel");

profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
            "text/csv, application/pdf, application/x-msexcel,application/excel,application/x-excel,application/excel,application/x-excel,application/excel, application/vnd.ms- excel,application/x-excel,application/x-msexcel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/excel,text/x-c");

Webdriver driver = new FirefoxDriver(profile);