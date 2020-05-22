try {
    HtmlPage page = webClient.getPage("http://www.w3schools.com/HTML/tryit.asp?filename=tryhtml_noframes");
    HtmlInlineFrame frame = page.getFirstByXPath("//iframe[@name='view']");
    page = webClient.getPage(page.getFullyQualifiedUrl(frame.getSrcAttribute()));
    System.out.println(page.asXml());
} catch (Exception e) {
    e.printStackTrace();
}