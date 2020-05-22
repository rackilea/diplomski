@Override
public void start(Stage primaryStage) {        
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog");
    alert.setHeaderText("This is a Custom Confirmation Dialog");
    alert.setContentText("We override the style classes of the dialog");
    ...
}