HtmlPage page = null;
try {
    page = webClient.getPage(url);
} catch (Exception e) {
    System.out.println("Get page error");
}
JavaScriptJobManager manager = page.getEnclosingWindow().getJobManager();
while (manager.getJobCount() > 0) {
    Thread.sleep(1000);
}
System.out.println(page.asXml());
return page;