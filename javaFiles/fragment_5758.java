java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);

    final WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
    HtmlPage page;

    webClient.waitForBackgroundJavaScript(10000);
    webClient.waitForBackgroundJavaScriptStartingBefore(10000);
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setRedirectEnabled(true);
    webClient.getOptions().setCssEnabled(true);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setAppletEnabled(false);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getOptions().setActiveXNative(true);
    webClient.getOptions().setAppletEnabled(true);

    page = webClient.getPage("https://salesforce--domain/secur/frontdoor.jsp?sid=SessionId");