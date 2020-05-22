ScrollPane scrollPane = new ScrollPane(content);
    scrollPane.setFitToWidth(true);
//    scrollPane.prefHeightProperty().bind(top.heightProperty());


    BorderPane root = new BorderPane(scrollPane);
    root.setTop(new MenuBar(new Menu("Foo")));

    Scene scene = new Scene(root);

    aStage.setScene(scene);

    root.applyCss();
    scrollPane.setPrefHeight(top.prefHeight(-1));
    root.requestLayout();

    aStage.sizeToScene();
    aStage.show();
    aStage.toFront();