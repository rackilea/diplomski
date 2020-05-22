@Given("^I navigate to the public ACME WebPage and select Login$")
public void iNavigateToTheAcmePublicWebPage() {
    pageFactory.AcmePublicWebPage().navigateTo(
      WebDriverManager.instance().getAcmeUrl());

    pageFactory.AcmePublicWebPage().closeNotificationPopUp(); //If there is one
    pageFactory.AcmePublicWebPage().selectLoginLink();
}

@When("^I close the browser$")
public void iCloseTheBrowser() {
    WebDriverManager.instance().closeBrowser();
}