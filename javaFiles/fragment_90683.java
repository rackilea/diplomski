final WebClient webClient = new WebClient();
final HtmlPage page1 = webClient.getPage("http://www.facebook.com");
final HtmlForm form = page1.getFormByName("login_form");

final HtmlSubmitInput button = form.getInputsByValue("Log in");
final HtmlTextInput textField = form.getInputByName("email");
textField.setValueAttribute("jon@jon.com");
final HtmlTextInput textField = form.getInputByName("pass");
textField.setValueAttribute("ahhhh");
final HtmlPage page2 = button.click();