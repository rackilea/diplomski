public class MyController implements Initializable{

    @FXML private Menu openRecentTab;

    // This method is called before the stage is shown
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MenuItem menuItem1 = new MenuItem("Menu Item 1");
        MenuItem menuItem2 = new MenuItem("Menu Item 2");
        openRecentTab.getItems().addAll(menuItem1, menuItem2);
    }
}