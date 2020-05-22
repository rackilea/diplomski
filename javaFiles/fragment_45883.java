FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("imagebutton.fxml"));
loader.setBuilderFactory(new ImageButtonBuilderFactory());
Parent root = loader.load();
Scene scene = new Scene(root);
...