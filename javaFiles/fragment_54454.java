try (final WebClient webClient = new WebClient()) {
    // do not stop at js errors
    webClient.getOptions().setThrowExceptionOnScriptError(false);

    webClient.getPage(searchUrl);
    // now wait for the js starting async (you can play with the timing)
    webClient.waitForBackgroundJavaScript(10000);

    // maybe the page was replaced from the async js
    HtmlPage page = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();

    System.out.println(page.asXml());
}