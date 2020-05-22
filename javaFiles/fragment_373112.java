@Given("...")
 public void navigateToUrl(String url) throws InterruptedException {
   chromeConverterApp.navigateToUrl(url);
   firefoxConverterApp.navigateToUrl(url);
 }
 @When("^..")
 public void enterCurrencies(String amount, String from, String to) throws InterruptedException {
   chromeConverterApp.enterCurrencies(amount, from, to);
   firefoxConverterApp.enterCurrencies(amount,from,to);
 }