String strURL = "https://www.checkmytrip.com" ;
java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_31)) {
    webClient.setAjaxController(new NicelyResynchronizingAjaxController());

    HtmlPage myPage = ((HtmlPage) webClient.getPage(strURL));
    webClient.waitForBackgroundJavaScript(10 * 1000);

    String theContent = myPage.asXml();
    System.out.println(theContent);
}