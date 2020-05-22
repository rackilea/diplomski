WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
webClient.getOptions().setJavaScriptEnabled(true);
webClient.getOptions().setCssEnabled(false); // I think this speeds the thing up
webClient.getOptions().setRedirectEnabled(true);
webClient.setAjaxController(new NicelyResynchronizingAjaxController());
webClient.getCookieManager().setCookiesEnabled(true);

String url="http://truckstop.com/";
String name="XXXX";
String accountNo="XXXX";
String pass="XXXX";

HtmlPage page = webClient.getPage(url);
System.out.println("1st page : "+page.asText());

HtmlForm form=(HtmlForm)page.getElementById("aspnetForm");
HtmlInput uName=(HtmlInput)form.getByXPath("//*[@id=\"ctl00_LoginControl_textUserName_text\"]").get(0);
uName.setValueAttribute(name);
HtmlInput acNo=(HtmlInput)form.getByXPath("//*[@id=\"ctl00_LoginControl_textCompanyAccount_text\"]").get(0);
acNo.setValueAttribute(accountNo);          
HtmlPasswordInput password=(HtmlPasswordInput)form.getByXPath("//*[@id=\"ctl00_LoginControl_textPassword\"]").get(0);
password.setValueAttribute(pass);
HtmlSubmitInput button = (HtmlSubmitInput) form.getByXPath("//*[@id=\"ctl00_LoginControl_buttonLogin\"]").get(0);

WebWindow window = page.getEnclosingWindow();
button.click();
while(window.getEnclosedPage() == page) {
    // The page hasn't changed.
    Thread.sleep(500);
}
// This loop above will wait until the page changes.
page = window.getEnclosedPage();
System.out.println("2nd Page : "+page.asText());

webClient.closeAllWindows();