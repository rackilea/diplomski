AnchorPane rootPane;
MyController controller = new MyController();
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("my.fxml"));
fxmlLoader.setRoot(rootPane);
fxmlLoader.setController(controller);
fxmlLoader.load();