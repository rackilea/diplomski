FXMLLoader loader = new FXMLLoader();
loader.setLocation(this.getClass().getResource("Sample.fxml"));
Controller controller = new Controller();
loader.setController(controller);
Pane root = loader.load();
Scene scene = new Scene(root);