try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
    // Get the first page
    final HtmlPage page1 = webClient.getPage("http://www.homedepot.ca");

    // Get the form that we are dealing with and within that form, 
    // find the submit button and the field that we want to change.
    final HtmlForm form = page1.getFormByName("search_terms_form");

    final HtmlElement button = form.getFirstByXPath("//button[@class='search-button']");
    final HtmlTextInput textField = form.getInputByName("q");

    // Change the value of the text field
    textField.setValueAttribute("drill");

    // Now submit the form by clicking the button 
    button.click();
    System.out.println(page1.getTitleText());
}