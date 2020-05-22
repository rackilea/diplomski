WebClient webClient = new WebClient(BrowserVersion.CHROME);

String url = "https://github.com/login";

webClient.getOptions().setJavaScriptEnabled(true);
webClient.getOptions().setThrowExceptionOnScriptError(false);
webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

HtmlPage page = webClient.getPage(url);
DomElement form = (DomElement) page.querySelector("form");

System.out.println(form.asXml());

webClient.close();