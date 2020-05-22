public static void main(String[] args) throws IOException {
    String url = "https://www.garageclothing.com/ca";

    try (final WebClient webClient = new WebClient()) {
        // do not stop at js errors
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(10000);

        HtmlPage page = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
        HtmlInput searchInput = (HtmlInput) page.getElementById("searchText");
        searchInput.type("red scarf");

        HtmlElement submitBtn = (HtmlElement) page.getElementByName("search");
        submitBtn.click();
        webClient.waitForBackgroundJavaScript(10000);

        page = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
        // System.out.println("------------------------------------------------");
        // System.out.println(page.asXml());

        System.out.println("------------------------------------------------");
        final DomNodeList<DomNode> divs = page.querySelectorAll(".divProdPriceSale");
        for (DomNode div : divs) {
            System.out.println(div.asText());
        }
    }
}