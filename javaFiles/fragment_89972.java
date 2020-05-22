Grid.driver().get("https://testpt1qa.com");

// Get top level parent for all nav elements
WebElement parent = Grid.driver().findElement(By.xpath("//nav[@id='main-menu']//ul//li"));

// Get the main menu items: main-menu > ul > li > a
// At this point you should have Test1, Test2, Test3 and Help.
List<WebElement> menuItems = parent.findElements(By.xpath(".//a[@rel='menuitem'"));

// Get menu items size
System.out.println("Number of menu items " + menuItems.size());

// Get the text for each menu
for (WebElement menuItem : menuItems) {
    System.out.println(menuItem.getText());

    // Now search for sub menu item by traversing up to the parent of the current menu item
    // This should get you Get Class1 etc based on the current menu in the loop
    List<WebElement> subMenuItems = menuItem.findElements(By.xpath(".//..//div//ul//li//a"));
    System.out.println("Number of sub menu items " + subMenuItems.size());
    for (WebElement subMenuItem : subMenuItems) {
        System.out.println(subMenuItem.getText());
    }
}