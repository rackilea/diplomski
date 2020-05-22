public static int showMessageDialog(String title, String object_message){
    stage = new Stage();
    stage.setMinHeight(150);
    stage.setMinWidth(250);
    stage.setTitle(title);
    stage.initModality(Modality.APPLICATION_MODAL);

    IntegerProperty returnCode = new SimpleIntegerProperty(-1);

    ok = new Button("OK");
    ok.setOnAction(ev -> {returnCode.set(1); stage.close();});

    gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setVgap(30);

    message = new Text(object_message);
    gridPane.addColumn(0, message, ok);
    scene = new Scene(gridPane);
    stage.setScene(scene);
    stage.showAndWait();

    return returnCode.get();
}