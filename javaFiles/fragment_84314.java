// feature file
Secnario Outline: Test user login
  Given ...
  And user input username: <value> into <element>
  And user input password: <value> into <element>

  Examples:
    | value | element |
    | user1 | id:username |
    | pwd1  | css:input.pwd |

// helper class to build Locator
public class Locator {

  public static By build(locator) {
    String[] parts = locator.split(":");
    String use = parts[0].trim().lowerCase();
    String value = parts[1].trim();

    if(use.equals("id")) {
      return By.id(value);
    }
    else if(use.equals("css")){
      return By.css(value);
    }
    .....
  }
}

// step definition
Then("^user input username: (.+) into (.+)$", 
      (String inputValue, String locatoExp) -> {

    driver.findElement(Locator.build(locatoExp)).sendKeys(inputValue);
});