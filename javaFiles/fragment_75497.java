try (final WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED)) {
    WebClientOptions options = webClient.getOptions();
    options.setCssEnabled(true);
    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    options.setTimeout(50000);
    webClient.addRequestHeader("Access-Control-Allow-Origin", "*");

    HtmlPage page = webClient.getPage("https://demo.tutorialzine.com/2009/09/simple-ajax-website-jquery/demo.html#page3");

    // important!  Give the headless browser enough time to execute JavaScript
    // The exact time to wait may depend on your application.
    webClient.setJavaScriptTimeout(10000);
    webClient.waitForBackgroundJavaScript(10000);
    //just wait
    Thread.sleep(10000);

    String xml = page.asXml();
    System.out.println(xml);
}