static void launchScreen(String fileName) {
    fileName = "/screens/" + fileName + ".fxml";
    try {
        Parent root =            
        FXMLLoader.load(MainMenuController.class.getResource(fileName));
        Scene scene = new Scene(root);
        stage.setTitle("Fortress Combat");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(420);
        });
    } catch (IOException e) {
        e.printStackTrace();
    }
}