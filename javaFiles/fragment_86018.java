private Scene sceneA;

static void launchScreen(String fileName) {
    if(fileName.equals("sceneA") && sceneA != null){
         /*if we want to open up sceneA and it has been created before (meaning it's not null) then open the already existing scene.*/
            stage.setTitle("Fortress Combat");
            stage.setScene(sceneA);
            stage.show();
            stage.setOnCloseRequest(t -> {
                Platform.exit();
                System.exit(420);
            });

    }else{
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
}