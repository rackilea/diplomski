try {
     final WebClient wc = new WebClient();
     wc.getOptions().setThrowExceptionOnScriptError(false);

     HtmlPage page = wc.getPage("https://www.google.com/");

     HtmlInput searchForm = page.getFirstByXPath("//input[@name='q']");
     searchForm.setValueAttribute("q");

     HtmlSubmitInput submitButton = page.getFirstByXPath("//input[@name='btnK']");
    HtmlPage pageAfterLogin = submitButton.click();

    System.out.println(pageAfterLogin.getUrl().toString());   

} catch (Exception e) {}