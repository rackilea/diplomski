WebClient webClient = new WebClient(BrowserVersion.CHROME);
webClient.getOptions().setJavaScriptEnabled(true); // enable javascript
webClient.getOptions().setThrowExceptionOnScriptError(false); //even if there is error in js continue
webClient.waitForBackgroundJavaScript(5000); // important! wait when javascript finishes rendering
HtmlPage page = webClient.getPage(url);

page.getElementById("tournamentTable");