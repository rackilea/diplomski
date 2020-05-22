public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        GraphFunc test = new GraphFunc();
        test.setPrefSize(500, 500);
        pane.getChildren().add(test);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }