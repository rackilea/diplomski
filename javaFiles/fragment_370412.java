createNewProject.setOnAction(event -> {
    statusText.setText("Please wait...");
    PauseTransition pause = new PauseTransition(
        Duration.seconds(1),
    );
    pause.setOnFinished(event -> {
        Parent root = FXMLLoader.load(
            getClass().getResource(
                "/view/scene/configure/NewProjectConfigureScene.fxml"
            )
        );
        Scene scene = new Scene(root);
        stage.setTitle("Configure New Project Settings");
        stage.setScene(scene);
        stage.sizeToScene();    
    });
    pause.play();
});