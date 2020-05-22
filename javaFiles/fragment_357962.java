@Given("^I enter the following details:$")
public void i_enter_the_following_details(Map<String, String> details) throws Throwable {
    for Map.Entry<String, String> entry : details.entrySet() {
        String key = entry.getKey();
        String value = entry.getValue();
        switch (key) {
            case "Date":
                // add the date to the form
                break;
            // ...
        }
    }
}