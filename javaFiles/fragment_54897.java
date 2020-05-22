panel = new MyPanel(); //a BorderPane, its size is set using "setPrefSize" method

root = new Group();
root.getChildren().add(panel);

scene = new Scene(root);

stage.setResizable(false);
stage.setScene(scene);
stage.show();
stage.sizeToScene();
stage.centerOnScreen();