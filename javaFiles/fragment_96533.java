@Test(description = "Test5")
public test_chooseCatagory() {
    chooseCatagory("ATM", "Airports");
}

private void chooseCatagory(String... catagories) {
    for(String catagory: catagories) {
        // click the down arrow at right to make the filter text box and
        // all option list display
        driver.findElement(By.cssSelector("div.multiselect__select"))
          .click();

        // input catagory into text box to filter matched options
        driver.findElement(By.cssSelector(".multiselect__tags #multiselect_categories"))
          .sendKeys(catagory);

        // click the option from filtered option list 
        driver.findElement(By.cssSelector(".multiselect__content-wrapper > ul"))
          .findElement(By.xpath("./li//span[text()='"+catagory+"']"))
          .click();

        // sleep 2 seconds before next choosing
        try {
         Thread.sleep(2000);
        }
        catch(Exception e) {
        } 
    } 
}