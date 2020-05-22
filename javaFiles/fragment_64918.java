@Given("^I am on the \"([^\"]*)\" page$")
public void i_am_on_the_page(String arg) throws throwable{

String newBaseURL = getBaseURL() + arg;
String currentURL = driver.getCurrentURL();
try{
    Assert.assertEquals(newBaseURL, currentURL);
}
catch(Exception e){
    driver.get(newBaseURL);
}