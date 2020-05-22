FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

// You first need to create a reference to your controller
Controller controller = new Controller();
loader.setController(controller);

Parent root = loader.load()

// Now call the setter from the Controller.java file:
controller.setLowTextField("This is The Console");

primaryStage.setTitle("Hello World");
primaryStage.setScene(new Scene(root, 300, 275));
primaryStage.show();