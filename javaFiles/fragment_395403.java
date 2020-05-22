try (WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    final HtmlPage page = webClient.getPage("http://www.reuters.com/article/2015/07/08/us-alibaba-singapore-post-idUSKCN0PI03J20150708");
    webClient.waitForBackgroundJavaScript(10000);
    System.out.println(page.asText());
}