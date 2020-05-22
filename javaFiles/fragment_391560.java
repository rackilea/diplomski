@FXML Button button;
@FXML MenuItem menuItem;

@FXML
private void doSomething(ActionEvent event) {
    Object source = event.getSource();
    if (button == source) {
        System.out.println("button clicked");
    } else if (menuItem == source) {
        System.out.println("menu item clicked");
    }
}