private Image generateNet(String face1, String face2, String face3, String face4, String face5, String face6) {

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);

    Label label1 = new Label(face1);
    label1.setRotate(90);
    GridPane.setHalignment(label1, HPos.CENTER);

    Label label2 = new Label(face2);
    GridPane.setHalignment(label2, HPos.CENTER);

    Label label3 = new Label(face3);
    GridPane.setHalignment(label3, HPos.CENTER);

    Label label4 = new Label(face4);
    GridPane.setHalignment(label4, HPos.CENTER);

    Label label5 = new Label(face5);
    GridPane.setHalignment(label5, HPos.CENTER);

    Label label6 = new Label(face6);
    label6.setRotate(90);
    GridPane.setHalignment(label6, HPos.CENTER);

    grid.add(label1, 1, 0);
    grid.add(label2, 0, 1);
    grid.add(label3, 1, 1);
    grid.add(label4, 2, 1);
    grid.add(label5, 3, 1);
    grid.add(label6, 1, 2);

    grid.setGridLinesVisible(true);

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(25);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(25);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(25);
    ColumnConstraints col4 = new ColumnConstraints();
    col4.setPercentWidth(25);
    grid.getColumnConstraints().addAll(col1, col2, col3, col4);

    RowConstraints row1 = new RowConstraints();
    row1.setPercentHeight(33.33);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(33.33);
    RowConstraints row3 = new RowConstraints();
    row3.setPercentHeight(33.33);
    grid.getRowConstraints().addAll(row1, row2, row3);
    grid.setPrefSize(600, 450);

    Scene tmpScene = new Scene(grid);
    tmpScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    return grid.snapshot(null, null);
}