IWorkbenchBrowserSupport support = PlatformUI.getWorkbench().getBrowserSupport();

IWebBrowser browser = support.getExternalBrowser();

URL url = ... url you want to open
browser.openURL(url);