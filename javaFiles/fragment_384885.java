java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
final WebClient webClient = new WebClient(BrowserVersion.CHROME);

webClient.getOptions().setJavaScriptEnabled(true);
webClient.getOptions().setThrowExceptionOnScriptError(false);
webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
webClient.getOptions().setTimeout(10000);

try {
    HtmlPage htmlPage = webClient.getPage("http://qatarsale.com/EnMain.aspx");

    Document doc = Jsoup.parse(htmlPage.asXml());

    System.out.println(doc.select("[id$=Label10]").text());

    ScriptResult result = htmlPage.executeJavaScript("__doPostBack('GridView1','Page$2')");
    htmlPage = (HtmlPage)result.getNewPage();

    Thread.sleep(3000); // delay needed for lazy loading, there might be something cleaner

    doc = Jsoup.parse(((HtmlPage)htmlPage).asXml());

    System.out.println(doc.select("[id$=Label10]").text());

} catch (Exception e) {
    e.printStackTrace();
} finally {
    webClient.close();
}