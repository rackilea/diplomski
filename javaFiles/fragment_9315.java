public class MyController {

    @FXML private Menu openRecentTab;

    @FXML public void addMenuItem() {
        MenuItem menuItem1 = new MenuItem("Menu Item 1");
        MenuItem menuItem2 = new MenuItem("Menu Item 2");    
        MenuItem menuItem3 = new MenuItem("Menu Item 3");

        // Add multiple items at once
        openRecentTab.getItems().addAll(menuItem1, menuItem2);
        // Add one item
        openRecentTab.getItems().add(menuItem3);
    }
}