@Test
public void cssSelector() throws Exception {
    try (final WebClient webClient = new WebClient()) {
        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");

        //get list of all divs
        final DomNodeList<DomNode> divs = page.querySelectorAll("div");
        for (DomNode div : divs) {
            ....
        }

        //get div which has the id 'breadcrumbs'
        final DomNode div = page.querySelector("div#breadcrumbs");
    }
}