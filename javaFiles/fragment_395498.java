Group root = new Group();
    root.getChildren().add(btReturn);
    Scene scene2 = new Scene(root, 600, 600, Color.LIGHTBLUE);
    btGenerate.setOnAction(e-> {
        primaryStage.setScene(scene2);
    });
    primaryStage.setTitle("Switch Scenes!");
    primaryStage.setScene(scene1);
    primaryStage.show();