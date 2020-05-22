ApplicationContext context = ... ;

FXMLLoader loader = new FXMLLoader(getClass().getResource("path/to/fxml"));
loader.setControllerFactory(context::getBean);
Parent root = loader.load();
SomeController controller = loader.getController(); // if you need it...
// ...